/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.guvnor.common.services.project.backend.server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Set;

import org.apache.maven.project.MavenProject;
import org.guvnor.common.services.project.model.GAV;
import org.guvnor.common.services.project.model.MavenRepositoryMetadata;
import org.guvnor.common.services.project.model.MavenRepositorySource;
import org.guvnor.common.services.project.model.Project;
import org.guvnor.common.services.project.service.ProjectRepositoryResolver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.scanner.embedder.MavenProjectLoader;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.uberfire.io.IOService;
import org.uberfire.java.nio.file.Path;

import static org.guvnor.common.services.project.backend.server.MavenLocalRepositoryUtils.*;
import static org.guvnor.common.services.project.backend.server.RepositoryResolverTestUtils.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProjectRepositoryResolverImplTest {

    @Mock
    private IOService ioService;

    private ProjectRepositoryResolverImpl service;

    private static java.nio.file.Path m2Folder = null;
    private static java.nio.file.Path settingsXmlPath = null;

    @BeforeClass
    public static void setupSystemProperties() {
        //These are not needed for the tests
        System.setProperty( "org.uberfire.nio.git.daemon.enabled",
                            "false" );
        System.setProperty( "org.uberfire.nio.git.ssh.enabled",
                            "false" );
        System.setProperty( "org.uberfire.sys.repo.monitor.disabled",
                            "true" );
    }

    @BeforeClass
    public static void setupMavenRepository() {
        try {
            m2Folder = Files.createTempDirectory( "temp-m2" );

            settingsXmlPath = generateSettingsXml( m2Folder );

        } catch ( IOException ioe ) {
            fail( ioe.getMessage() );
        }
    }

    @Before
    public void setup() {
        service = new ProjectRepositoryResolverImpl( ioService );
    }

    @AfterClass
    public static void teardownMavenRepository() {
        tearDownMavenRepository( m2Folder );
    }

    @After
    public void tearDown() {
        tearDownMavenRepositoryContent( m2Folder );
    }

    @Test
    public void testGetRemoteRepositoriesMetaData_WithoutExplicitProjectRepository() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path pomXmlPath = mock( org.uberfire.backend.vfs.Path.class );

        final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "  <modelVersion>4.0.0</modelVersion>\n" +
                "  <groupId>org.guvnor</groupId>\n" +
                "  <artifactId>test</artifactId>\n" +
                "  <version>0.0.1</version>\n" +
                "</project>";
        when( project.getPomXMLPath() ).thenReturn( pomXmlPath );
        when( pomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
        when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final Set<MavenRepositoryMetadata> metadata = service.getRemoteRepositoriesMetaData( project );
            assertNotNull( metadata );
            assertEquals( 5,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );
            assertContainsRepository( "jboss-developer-repository-group",
                                      "https://repository.jboss.org/nexus/content/groups/developer/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "jboss-public-repository-group",
                                      "http://repository.jboss.org/nexus/content/groups/public/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "jboss-origin-repository-group",
                                      "https://origin-repository.jboss.org/nexus/content/groups/ea/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "central",
                                      "https://repo.maven.apache.org/maven2",
                                      MavenRepositorySource.PROJECT,
                                      metadata );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRemoteRepositoriesMetaData_WithExplicitProjectRepository() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path pomXmlPath = mock( org.uberfire.backend.vfs.Path.class );

        final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "  <modelVersion>4.0.0</modelVersion>\n" +
                "  <groupId>org.guvnor</groupId>\n" +
                "  <artifactId>test</artifactId>\n" +
                "  <version>0.0.1</version>\n" +
                "  <repositories>\n" +
                "    <repository>\n" +
                "      <id>explicit-repo</id>\n" +
                "      <name>Explicit Repository</name>\n" +
                "      <url>http://localhost/maven2/</url>\n" +
                "    </repository>\n" +
                "  </repositories>\n" +
                "</project>";
        when( project.getPomXMLPath() ).thenReturn( pomXmlPath );
        when( pomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
        when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final Set<MavenRepositoryMetadata> metadata = service.getRemoteRepositoriesMetaData( project );
            assertNotNull( metadata );
            assertEquals( 6,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );
            assertContainsRepository( "jboss-developer-repository-group",
                                      "https://repository.jboss.org/nexus/content/groups/developer/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "jboss-public-repository-group",
                                      "http://repository.jboss.org/nexus/content/groups/public/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "jboss-origin-repository-group",
                                      "https://origin-repository.jboss.org/nexus/content/groups/ea/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "central",
                                      "https://repo.maven.apache.org/maven2",
                                      MavenRepositorySource.PROJECT,
                                      metadata );
            assertContainsRepository( "explicit-repo",
                                      "http://localhost/maven2/",
                                      MavenRepositorySource.PROJECT,
                                      metadata );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRemoteRepositoriesMetaData_WithDistributionManagementRepository() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path pomXmlPath = mock( org.uberfire.backend.vfs.Path.class );

        final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "  <modelVersion>4.0.0</modelVersion>\n" +
                "  <groupId>org.guvnor</groupId>\n" +
                "  <artifactId>test</artifactId>\n" +
                "  <version>0.0.1</version>\n" +
                "  <distributionManagement>\n" +
                "    <repository>\n" +
                "      <id>distribution-repo</id>\n" +
                "      <name>Distribution Repository</name>\n" +
                "      <url>http://distribution-host/maven2/</url>\n" +
                "    </repository>\n" +
                "  </distributionManagement>\n" +
                "</project>";
        when( project.getPomXMLPath() ).thenReturn( pomXmlPath );
        when( pomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
        when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final Set<MavenRepositoryMetadata> metadata = service.getRemoteRepositoriesMetaData( project );
            assertNotNull( metadata );
            assertEquals( 6,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );
            assertContainsRepository( "jboss-developer-repository-group",
                                      "https://repository.jboss.org/nexus/content/groups/developer/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "jboss-public-repository-group",
                                      "http://repository.jboss.org/nexus/content/groups/public/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "jboss-origin-repository-group",
                                      "https://origin-repository.jboss.org/nexus/content/groups/ea/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "central",
                                      "https://repo.maven.apache.org/maven2",
                                      MavenRepositorySource.PROJECT,
                                      metadata );
            assertContainsRepository( "distribution-repo",
                                      "http://distribution-host/maven2/",
                                      MavenRepositorySource.DISTRIBUTION_MANAGEMENT,
                                      metadata );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRemoteRepositoriesMetaData_WithDistributionManagementSnapshotRepository_NonSnapshotVersion() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path pomXmlPath = mock( org.uberfire.backend.vfs.Path.class );

        final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "  <modelVersion>4.0.0</modelVersion>\n" +
                "  <groupId>org.guvnor</groupId>\n" +
                "  <artifactId>test</artifactId>\n" +
                "  <version>0.0.1</version>\n" +
                "  <distributionManagement>\n" +
                "    <snapshotRepository>\n" +
                "      <id>distribution-repo</id>\n" +
                "      <name>Distribution Repository</name>\n" +
                "      <url>http://distribution-host/maven2/</url>\n" +
                "    </snapshotRepository>\n" +
                "  </distributionManagement>\n" +
                "</project>";
        when( project.getPomXMLPath() ).thenReturn( pomXmlPath );
        when( pomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
        when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final Set<MavenRepositoryMetadata> metadata = service.getRemoteRepositoriesMetaData( project );
            assertNotNull( metadata );
            assertEquals( 5,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );
            assertContainsRepository( "jboss-developer-repository-group",
                                      "https://repository.jboss.org/nexus/content/groups/developer/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "jboss-public-repository-group",
                                      "http://repository.jboss.org/nexus/content/groups/public/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "jboss-origin-repository-group",
                                      "https://origin-repository.jboss.org/nexus/content/groups/ea/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "central",
                                      "https://repo.maven.apache.org/maven2",
                                      MavenRepositorySource.PROJECT,
                                      metadata );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRemoteRepositoriesMetaData_WithDistributionManagementSnapshotRepository_SnapshotVersion() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path pomXmlPath = mock( org.uberfire.backend.vfs.Path.class );

        final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "  <modelVersion>4.0.0</modelVersion>\n" +
                "  <groupId>org.guvnor</groupId>\n" +
                "  <artifactId>test</artifactId>\n" +
                "  <version>0.0.1-SNAPSHOT</version>\n" +
                "  <distributionManagement>\n" +
                "    <snapshotRepository>\n" +
                "      <id>distribution-repo</id>\n" +
                "      <name>Distribution Repository</name>\n" +
                "      <url>http://distribution-host/maven2/</url>\n" +
                "    </snapshotRepository>\n" +
                "  </distributionManagement>\n" +
                "</project>";
        when( project.getPomXMLPath() ).thenReturn( pomXmlPath );
        when( pomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
        when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final Set<MavenRepositoryMetadata> metadata = service.getRemoteRepositoriesMetaData( project );
            assertNotNull( metadata );
            assertEquals( 6,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );
            assertContainsRepository( "jboss-developer-repository-group",
                                      "https://repository.jboss.org/nexus/content/groups/developer/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "jboss-public-repository-group",
                                      "http://repository.jboss.org/nexus/content/groups/public/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "jboss-origin-repository-group",
                                      "https://origin-repository.jboss.org/nexus/content/groups/ea/",
                                      MavenRepositorySource.SETTINGS,
                                      metadata );
            assertContainsRepository( "central",
                                      "https://repo.maven.apache.org/maven2",
                                      MavenRepositorySource.PROJECT,
                                      metadata );
            assertContainsRepository( "distribution-repo",
                                      "http://distribution-host/maven2/",
                                      MavenRepositorySource.DISTRIBUTION_MANAGEMENT,
                                      metadata );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_NewGAV_NotInstalledNotDeployed() {
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav );
            assertNotNull( metadata );
            assertEquals( 0,
                          metadata.size() );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_NewGAV_IsInstalledNotDeployed() {
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "</project>";

            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav );
            assertNotNull( metadata );
            assertEquals( 1,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_NewGAV_IsInstalledIsDeployed() {
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        java.nio.file.Path remoteRepositoryFolder = null;

        try {
            remoteRepositoryFolder = Files.createTempDirectory( "distribution-repo" );

            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "  <distributionManagement>\n" +
                    "    <repository>\n" +
                    "      <id>distribution-repo</id>\n" +
                    "      <name>Distribution Repository</name>\n" +
                    "      <url>file://" + remoteRepositoryFolder.toString() + "</url>\n" +
                    "    </repository>\n" +
                    "  </distributionManagement>\n" +
                    "</project>";

            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );
            deployArtifact( mavenProject,
                            pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav );
            assertNotNull( metadata );
            assertEquals( 1,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );

        } catch ( IOException ioe ) {
            fail( ioe.getMessage() );

        } finally {
            tearDownMavenRepository( remoteRepositoryFolder );
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_NewGAV_NotInstalledIsDeployed() {
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        java.nio.file.Path remoteRepositoryFolder = null;

        try {
            remoteRepositoryFolder = Files.createTempDirectory( "distribution-repo" );

            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "  <distributionManagement>\n" +
                    "    <repository>\n" +
                    "      <id>distribution-repo</id>\n" +
                    "      <name>Distribution Repository</name>\n" +
                    "      <url>file://" + remoteRepositoryFolder.toString() + "</url>\n" +
                    "    </repository>\n" +
                    "  </distributionManagement>\n" +
                    "</project>";

            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            deployArtifact( mavenProject,
                            pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav );
            assertNotNull( metadata );
            assertEquals( 0,
                          metadata.size() );

        } catch ( IOException ioe ) {
            fail( ioe.getMessage() );

        } finally {
            tearDownMavenRepository( remoteRepositoryFolder );
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_NewGAV_IsInstalledIsDeployed_Filtered() {
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        java.nio.file.Path remoteRepositoryFolder = null;

        try {
            remoteRepositoryFolder = Files.createTempDirectory( "distribution-repo" );

            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "  <distributionManagement>\n" +
                    "    <repository>\n" +
                    "      <id>distribution-repo</id>\n" +
                    "      <name>Distribution Repository</name>\n" +
                    "      <url>file://" + remoteRepositoryFolder.toString() + "</url>\n" +
                    "    </repository>\n" +
                    "  </distributionManagement>\n" +
                    "</project>";

            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );
            deployArtifact( mavenProject,
                            pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav,
                                                                                                    new MavenRepositoryMetadata( "local",
                                                                                                                                 m2Folder.toString(),
                                                                                                                                 MavenRepositorySource.LOCAL ) );
            assertNotNull( metadata );
            assertEquals( 1,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );

        } catch ( IOException ioe ) {
            fail( ioe.getMessage() );

        } finally {
            tearDownMavenRepository( remoteRepositoryFolder );
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_ExplicitGAV_NotInstalledNotDeployed() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path pomXmlPath = mock( org.uberfire.backend.vfs.Path.class );

        final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "  <modelVersion>4.0.0</modelVersion>\n" +
                "  <groupId>org.guvnor</groupId>\n" +
                "  <artifactId>test</artifactId>\n" +
                "  <version>0.0.1</version>\n" +
                "</project>";
        final GAV gav = new GAV( "org.guvnor",
                                 "test",
                                 "0.0.1" );

        when( project.getPomXMLPath() ).thenReturn( pomXmlPath );
        when( pomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
        when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav,
                                                                                                    project );
            assertNotNull( metadata );
            assertEquals( 0,
                          metadata.size() );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_ExplicitGAV_IsInstalledNotDeployed() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path vfsPomXmlPath = mock( org.uberfire.backend.vfs.Path.class );
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "</project>";

            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            when( project.getPomXMLPath() ).thenReturn( vfsPomXmlPath );
            when( vfsPomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
            when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav,
                                                                                                    project );
            assertNotNull( metadata );
            assertEquals( 1,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_ExplicitGAV_IsInstalledIsDeployed() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path vfsPomXmlPath = mock( org.uberfire.backend.vfs.Path.class );
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        java.nio.file.Path remoteRepositoryFolder = null;

        try {
            remoteRepositoryFolder = Files.createTempDirectory( "distribution-repo" );

            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "  <distributionManagement>\n" +
                    "    <repository>\n" +
                    "      <id>distribution-repo</id>\n" +
                    "      <name>Distribution Repository</name>\n" +
                    "      <url>file://" + remoteRepositoryFolder.toString() + "</url>\n" +
                    "    </repository>\n" +
                    "  </distributionManagement>\n" +
                    "</project>";

            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            when( project.getPomXMLPath() ).thenReturn( vfsPomXmlPath );
            when( vfsPomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
            when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );
            deployArtifact( mavenProject,
                            pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav,
                                                                                                    project );
            assertNotNull( metadata );
            assertEquals( 2,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );
            assertContainsRepository( "distribution-repo",
                                      "file://" + remoteRepositoryFolder.toString(),
                                      MavenRepositorySource.DISTRIBUTION_MANAGEMENT,
                                      metadata );

        } catch ( IOException ioe ) {
            fail( ioe.getMessage() );

        } finally {
            tearDownMavenRepository( remoteRepositoryFolder );
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_ExplicitGAV_NotInstalledIsDeployed() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path vfsPomXmlPath = mock( org.uberfire.backend.vfs.Path.class );
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        java.nio.file.Path remoteRepositoryFolder = null;

        try {
            remoteRepositoryFolder = Files.createTempDirectory( "distribution-repo" );

            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "  <distributionManagement>\n" +
                    "    <repository>\n" +
                    "      <id>distribution-repo</id>\n" +
                    "      <name>Distribution Repository</name>\n" +
                    "      <url>file://" + remoteRepositoryFolder.toString() + "</url>\n" +
                    "    </repository>\n" +
                    "  </distributionManagement>\n" +
                    "</project>";

            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            when( project.getPomXMLPath() ).thenReturn( vfsPomXmlPath );
            when( vfsPomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
            when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            deployArtifact( mavenProject,
                            pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav,
                                                                                                    project );
            assertNotNull( metadata );
            assertEquals( 1,
                          metadata.size() );

            assertContainsRepository( "distribution-repo",
                                      "file://" + remoteRepositoryFolder.toString(),
                                      MavenRepositorySource.DISTRIBUTION_MANAGEMENT,
                                      metadata );

            final Set<MavenRepositoryMetadata> metadata2 = service.getRepositoriesResolvingArtifact( gav,
                                                                                                     project );
            assertNotNull( metadata2 );
            assertEquals( 1,
                          metadata2.size() );

            assertContainsRepository( "distribution-repo",
                                      "file://" + remoteRepositoryFolder.toString(),
                                      MavenRepositorySource.DISTRIBUTION_MANAGEMENT,
                                      metadata2 );

        } catch ( IOException ioe ) {
            fail( ioe.getMessage() );

        } finally {
            tearDownMavenRepository( remoteRepositoryFolder );
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_ExplicitGAV_IsInstalledIsDeployed_Filtered() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path vfsPomXmlPath = mock( org.uberfire.backend.vfs.Path.class );
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        java.nio.file.Path remoteRepositoryFolder = null;

        try {
            remoteRepositoryFolder = Files.createTempDirectory( "distribution-repo" );

            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "  <distributionManagement>\n" +
                    "    <repository>\n" +
                    "      <id>distribution-repo</id>\n" +
                    "      <name>Distribution Repository</name>\n" +
                    "      <url>file://" + remoteRepositoryFolder.toString() + "</url>\n" +
                    "    </repository>\n" +
                    "  </distributionManagement>\n" +
                    "</project>";

            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            when( project.getPomXMLPath() ).thenReturn( vfsPomXmlPath );
            when( vfsPomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
            when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );
            deployArtifact( mavenProject,
                            pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav,
                                                                                                    project,
                                                                                                    new MavenRepositoryMetadata( "distribution-repo",
                                                                                                                                 "file://" + remoteRepositoryFolder.toString(),
                                                                                                                                 MavenRepositorySource.DISTRIBUTION_MANAGEMENT ) );
            assertNotNull( metadata );
            assertEquals( 1,
                          metadata.size() );

            assertContainsRepository( "distribution-repo",
                                      "file://" + remoteRepositoryFolder.toString(),
                                      MavenRepositorySource.DISTRIBUTION_MANAGEMENT,
                                      metadata );

        } catch ( IOException ioe ) {
            fail( ioe.getMessage() );

        } finally {
            tearDownMavenRepository( remoteRepositoryFolder );
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_ImplicitGAV_NotInstalledNotDeployed() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path pomXmlPath = mock( org.uberfire.backend.vfs.Path.class );

        final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "  <modelVersion>4.0.0</modelVersion>\n" +
                "  <groupId>org.guvnor</groupId>\n" +
                "  <artifactId>test</artifactId>\n" +
                "  <version>0.0.1</version>\n" +
                "</project>";

        when( project.getPomXMLPath() ).thenReturn( pomXmlPath );
        when( pomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
        when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( pomXml );
            assertNotNull( metadata );
            assertEquals( 0,
                          metadata.size() );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_ImplicitGAV_IsInstalledNotDeployed() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path vfsPomXmlPath = mock( org.uberfire.backend.vfs.Path.class );
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        try {
            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "</project>";

            when( project.getPomXMLPath() ).thenReturn( vfsPomXmlPath );
            when( vfsPomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
            when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( pomXml );
            assertNotNull( metadata );
            assertEquals( 1,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_ImplicitGAV_IsInstalledIsDeployed() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path vfsPomXmlPath = mock( org.uberfire.backend.vfs.Path.class );
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        java.nio.file.Path remoteRepositoryFolder = null;

        try {
            remoteRepositoryFolder = Files.createTempDirectory( "distribution-repo" );

            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "  <distributionManagement>\n" +
                    "    <repository>\n" +
                    "      <id>distribution-repo</id>\n" +
                    "      <name>Distribution Repository</name>\n" +
                    "      <url>file://" + remoteRepositoryFolder.toString() + "</url>\n" +
                    "    </repository>\n" +
                    "  </distributionManagement>\n" +
                    "</project>";

            when( project.getPomXMLPath() ).thenReturn( vfsPomXmlPath );
            when( vfsPomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
            when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );
            deployArtifact( mavenProject,
                            pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( pomXml );
            assertNotNull( metadata );
            assertEquals( 2,
                          metadata.size() );

            assertContainsRepository( "local",
                                      m2Folder.toString(),
                                      MavenRepositorySource.LOCAL,
                                      metadata );
            assertContainsRepository( "distribution-repo",
                                      "file://" + remoteRepositoryFolder.toString(),
                                      MavenRepositorySource.DISTRIBUTION_MANAGEMENT,
                                      metadata );

        } catch ( IOException ioe ) {
            fail( ioe.getMessage() );

        } finally {
            tearDownMavenRepository( remoteRepositoryFolder );
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_ImplicitGAV_NotInstalledIsDeployed() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path vfsPomXmlPath = mock( org.uberfire.backend.vfs.Path.class );
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        java.nio.file.Path remoteRepositoryFolder = null;

        try {
            remoteRepositoryFolder = Files.createTempDirectory( "distribution-repo" );

            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "  <distributionManagement>\n" +
                    "    <repository>\n" +
                    "      <id>distribution-repo</id>\n" +
                    "      <name>Distribution Repository</name>\n" +
                    "      <url>file://" + remoteRepositoryFolder.toString() + "</url>\n" +
                    "    </repository>\n" +
                    "  </distributionManagement>\n" +
                    "</project>";

            when( project.getPomXMLPath() ).thenReturn( vfsPomXmlPath );
            when( vfsPomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
            when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            deployArtifact( mavenProject,
                            pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( pomXml );
            assertNotNull( metadata );
            assertEquals( 1,
                          metadata.size() );

            assertContainsRepository( "distribution-repo",
                                      "file://" + remoteRepositoryFolder.toString(),
                                      MavenRepositorySource.DISTRIBUTION_MANAGEMENT,
                                      metadata );

            final Set<MavenRepositoryMetadata> metadata2 = service.getRepositoriesResolvingArtifact( pomXml );
            assertNotNull( metadata2 );
            assertEquals( 1,
                          metadata2.size() );

            assertContainsRepository( "distribution-repo",
                                      "file://" + remoteRepositoryFolder.toString(),
                                      MavenRepositorySource.DISTRIBUTION_MANAGEMENT,
                                      metadata2 );

        } catch ( IOException ioe ) {
            fail( ioe.getMessage() );

        } finally {
            tearDownMavenRepository( remoteRepositoryFolder );
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_ImplicitGAV_IsInstalledIsDeployed_Filtered() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path vfsPomXmlPath = mock( org.uberfire.backend.vfs.Path.class );
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );

        java.nio.file.Path remoteRepositoryFolder = null;

        try {
            remoteRepositoryFolder = Files.createTempDirectory( "distribution-repo" );

            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "  <distributionManagement>\n" +
                    "    <repository>\n" +
                    "      <id>distribution-repo</id>\n" +
                    "      <name>Distribution Repository</name>\n" +
                    "      <url>file://" + remoteRepositoryFolder.toString() + "</url>\n" +
                    "    </repository>\n" +
                    "  </distributionManagement>\n" +
                    "</project>";

            when( project.getPomXMLPath() ).thenReturn( vfsPomXmlPath );
            when( vfsPomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
            when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );
            deployArtifact( mavenProject,
                            pomXml );

            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( pomXml,
                                                                                                    new MavenRepositoryMetadata( "distribution-repo",
                                                                                                                                 "file://" + remoteRepositoryFolder.toString(),
                                                                                                                                 MavenRepositorySource.DISTRIBUTION_MANAGEMENT ) );
            assertNotNull( metadata );
            assertEquals( 1,
                          metadata.size() );

            assertContainsRepository( "distribution-repo",
                                      "file://" + remoteRepositoryFolder.toString(),
                                      MavenRepositorySource.DISTRIBUTION_MANAGEMENT,
                                      metadata );

        } catch ( IOException ioe ) {
            fail( ioe.getMessage() );

        } finally {
            tearDownMavenRepository( remoteRepositoryFolder );
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_Disabled1() {
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );
        final String oldConflictingGavCheckSetting = System.getProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED );

        try {
            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "</project>";

            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );
            System.setProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED,
                                "true" );

            //Re-instantiate service to pick-up System Property
            service = new ProjectRepositoryResolverImpl( ioService );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );

            //Without being disabled this would return one resolved (LOCAL) Repository
            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav );
            assertNotNull( metadata );
            assertEquals( 0,
                          metadata.size() );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
            if ( oldConflictingGavCheckSetting != null ) {
                System.setProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED,
                                    oldConflictingGavCheckSetting );
            } else {
                System.clearProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_Disabled2() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path vfsPomXmlPath = mock( org.uberfire.backend.vfs.Path.class );
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );
        final String oldConflictingGavCheckSetting = System.getProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED );

        try {
            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "</project>";

            final GAV gav = new GAV( "org.guvnor",
                                     "test",
                                     "0.0.1" );

            when( project.getPomXMLPath() ).thenReturn( vfsPomXmlPath );
            when( vfsPomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
            when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );
            System.setProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED,
                                "true" );

            //Re-instantiate service to pick-up System Property
            service = new ProjectRepositoryResolverImpl( ioService );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );

            //Without being disabled this would return one resolved (LOCAL) Repository
            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( gav,
                                                                                                    project );
            assertNotNull( metadata );
            assertEquals( 0,
                          metadata.size() );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
            if ( oldConflictingGavCheckSetting != null ) {
                System.setProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED,
                                    oldConflictingGavCheckSetting );
            } else {
                System.clearProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED );
            }
        }
    }

    @Test
    public void testGetRepositoriesResolvingArtifact_Disabled3() {
        final Project project = mock( Project.class );
        final org.uberfire.backend.vfs.Path vfsPomXmlPath = mock( org.uberfire.backend.vfs.Path.class );
        final String oldSettingsXmlPath = System.getProperty( "kie.maven.settings.custom" );
        final String oldConflictingGavCheckSetting = System.getProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED );

        try {
            final String pomXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<project xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\" xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                    "  <modelVersion>4.0.0</modelVersion>\n" +
                    "  <groupId>org.guvnor</groupId>\n" +
                    "  <artifactId>test</artifactId>\n" +
                    "  <version>0.0.1</version>\n" +
                    "</project>";

            when( project.getPomXMLPath() ).thenReturn( vfsPomXmlPath );
            when( vfsPomXmlPath.toURI() ).thenReturn( "default://p0/pom.xml" );
            when( ioService.readAllString( any( Path.class ) ) ).thenReturn( pomXml );

            System.setProperty( "kie.maven.settings.custom",
                                settingsXmlPath.toString() );
            System.setProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED,
                                "true" );

            //Re-instantiate service to pick-up System Property
            service = new ProjectRepositoryResolverImpl( ioService );

            final InputStream pomStream = new ByteArrayInputStream( pomXml.getBytes( StandardCharsets.UTF_8 ) );
            final MavenProject mavenProject = MavenProjectLoader.parseMavenPom( pomStream );
            installArtifact( mavenProject,
                             pomXml );

            //Without being disabled this would return one resolved (LOCAL) Repository
            final Set<MavenRepositoryMetadata> metadata = service.getRepositoriesResolvingArtifact( pomXml );
            assertNotNull( metadata );
            assertEquals( 0,
                          metadata.size() );

        } finally {
            if ( oldSettingsXmlPath != null ) {
                System.setProperty( "kie.maven.settings.custom",
                                    oldSettingsXmlPath );
            }
            if ( oldConflictingGavCheckSetting != null ) {
                System.setProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED,
                                    oldConflictingGavCheckSetting );
            } else {
                System.clearProperty( ProjectRepositoryResolver.CONFLICTING_GAV_CHECK_DISABLED );
            }
        }
    }

    private void assertContainsRepository( final String id,
                                           final String url,
                                           final MavenRepositorySource source,
                                           final Collection<MavenRepositoryMetadata> metadata ) {
        for ( MavenRepositoryMetadata md : metadata ) {
            if ( md.getId().equals( id ) && md.getUrl().equals( url ) && md.getSource().equals( source ) ) {
                return;
            }
        }
        fail( "Repository Id '" + id + "' not found." );
    }

}
