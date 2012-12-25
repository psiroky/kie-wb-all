/*
 * Copyright 2012 JBoss Inc
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

package org.kie.guvnor.m2repo.backend.server;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.kie.builder.ReleaseId;
import org.kie.guvnor.m2repo.model.GAV;


@ApplicationScoped
public class M2Repository {
    
    public static final String M2_REPO_ROOT = "repository";
    public static final String REPO_ID_SNAPSHOTS = "snapshots";
    public static final String REPO_ID_RELEASES = "releases";
    private static final int BUFFER_SIZE = 1024;
    
    private File snapshotsRepository;
    private File releasesRepository;
    
    @PostConstruct
    protected void init() {
        setM2Repos();
    }
    
    private void setM2Repos() {
        snapshotsRepository = new File(getM2RepositoryRootDir() + File.separator + REPO_ID_SNAPSHOTS);
        if (!snapshotsRepository.exists()) {
            snapshotsRepository.mkdirs();
        }
        releasesRepository = new File(getM2RepositoryRootDir() + File.separator + REPO_ID_RELEASES);
        if (!releasesRepository.exists()) {
            releasesRepository.mkdirs();
        }       
    }
    
    protected String getM2RepositoryRootDir() {
        if (!M2_REPO_ROOT.endsWith(File.separator)) {
            return M2_REPO_ROOT + File.separator;
        } else {
            return M2_REPO_ROOT;
        }
    }
    
    public void addFile(InputStream is, GAV gav) {
        OutputStream outStream = null;
        try {
            //TODO: at the moment, we just assume classifier is null, target repo id is RELEASES
            String classifier = null;
            String fullPathToLocalFile = toURL(getM2RepositoryRootDir() + REPO_ID_RELEASES, gav, classifier);
            final File file = new File(fullPathToLocalFile);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } 
            file.isDirectory();
            outStream = new BufferedOutputStream(new FileOutputStream(file));
            final byte[] buf = new byte[BUFFER_SIZE];
            int byteRead = 0;
            while ((byteRead = is.read(buf)) != -1) {
                outStream.write(buf, 0, byteRead);
            }        
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
            }
        }
    }
    
    public boolean deleteFile(String[] fullPaths) {
        for (String fullPath : fullPaths) {
            System.out.println("-------deleting: " + fullPath);
            final File file = new File(fullPath);
            if (file.exists()) {
                System.out.println("-------deleted: " + fullPath);
                file.delete();
            }
        }
        return true;
    }

    /**
     * Finds files within the repository with the given filters.
     * 
     * @return an collection of java.io.File with the matching files
     */
    public Collection<File> listFiles() {
        return listFiles(null);
    }
    
    /**
     * Finds files within the repository with the given filters.
     *
     * @param filters filter to apply when finding files. The filter is used to create a wildcard matcher, ie., "*fileter*.*", in which "*" is  
     * to represent a multiple wildcard characters. 
     * @return an collection of java.io.File with the matching files
     */
    public Collection<File> listFiles(String filters) {
        String wildcard = "*.jar";
        if(filters != null) {
            wildcard = "*" + filters + "*.jar";
        }
        Collection<File> files = FileUtils.listFiles(
                releasesRepository, 
                new WildcardFileFilter(wildcard, IOCase.INSENSITIVE),
                DirectoryFileFilter.DIRECTORY
              );
        
        return files;
    }
    
    public InputStream loadFile(String path) { 
        try {
            return new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public String getFileName(String path) { 
        return (new File(path)).getName();        
    }
    
    public String loadPOM(String path) {
        try {
            ZipFile zip = new ZipFile(new File(path));

            for (Enumeration e = zip.entries(); e.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry)e.nextElement();
            
                if(entry.getName().startsWith("META-INF/maven") &&  entry.getName().endsWith("pom.xml")) {
                    InputStream is = zip.getInputStream(entry);
                    
                    InputStreamReader isr = new InputStreamReader(is, "UTF-8");          
                    StringBuilder sb = new StringBuilder();
                    for (int c = isr.read(); c != -1; c = isr.read()) {
                        sb.append((char)c);
                    }
                    return sb.toString();
                }
            }
        } catch (ZipException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static String loadPOM(InputStream is) {
        try {
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null)  {
                System.out.println("entry: " + entry.getName() + ", " + entry.getSize());
                        // consume all the data from this entry
                if(entry.getName().startsWith("META-INF/maven") &&  entry.getName().endsWith("pom.xml")) {
                    InputStreamReader isr = new InputStreamReader(zis, "UTF-8");          
                    StringBuilder sb = new StringBuilder();
                    for (int c = isr.read(); c != -1; c = isr.read()) {
                        sb.append((char)c);
                    }
                    return sb.toString();
                }
            }
        } catch (ZipException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    protected String toURL(final String repository, GAV gav, String classifier) {
        final StringBuilder sb = new StringBuilder(repository);

        if (!repository.endsWith(File.separator)) {
            sb.append(File.separator);
        }

        return sb.append(gav.getGroupId().replace(".", File.separator))
                .append(File.separator).append(gav.getArtifactId())
                .append(File.separator).append(gav.getVersion())
                .append(File.separator).append(toFileName(gav, classifier)).toString();
    }

    protected String toFileName(GAV gav, String classifier) {
        if (classifier != null) {
            return gav.getArtifactId() + "-" + gav.getVersion() + "-" + classifier + "." + getFileExtension();
        }

        return gav.getArtifactId() + "-" + gav.getVersion() + "." + getFileExtension();
    }
    
    private String getFileExtension() {
        //TODO: at the moment, we just assume extension type is jar
        String type = "jar";
        
        if (type.equalsIgnoreCase("ear")) {
            return "ear";
        } else if (type.equalsIgnoreCase("pom")) {
            return "pom";
        } else if (type.equalsIgnoreCase("war")) {
            return "war";
        }

        return "jar";
    }
}
