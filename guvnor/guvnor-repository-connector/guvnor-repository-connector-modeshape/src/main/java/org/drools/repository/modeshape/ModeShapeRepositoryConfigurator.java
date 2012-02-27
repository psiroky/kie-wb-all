package org.drools.repository.modeshape;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

import javax.jcr.LoginException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Workspace;

import org.drools.repository.JCRRepositoryConfigurator;
import org.modeshape.jcr.CndNodeTypeReader;
import org.modeshape.jcr.JcrRepositoryFactory;

/**
 * This specialized {@link JCRRepositoryConfigurator}
 */
public class ModeShapeRepositoryConfigurator extends JCRRepositoryConfigurator {

    public ModeShapeRepositoryConfigurator() {
        defaultJCRImplClass = JcrRepositoryFactory.class.getName();
    }
    
    public void registerNodeTypesFromCndFile(String cndFileName, Session session, Workspace workspace)
            throws RepositoryException {
        CndNodeTypeReader reader = new CndNodeTypeReader(session);
        try {
            reader.read(cndFileName);
            workspace.getNodeTypeManager().registerNodeTypes(reader.getNodeTypeDefinitions(), false);
        } catch (IOException e) {
            throw new RepositoryException("Registering node types for repository failed.", e);
        }
    }

    public Session login(String userName) throws RepositoryException {
        Session session = null;
        try {
            session = AccessController.doPrivileged( new PrivilegedExceptionAction<Session>() {
                public Session run() throws Exception {
                    return repository.login();
                }
            });
        } catch (PrivilegedActionException pae) {
            throw new RepositoryException(pae.getMessage(),pae);
        }
        return session;
    }

    public void shutdown() {
        if (factory instanceof org.modeshape.jcr.api.RepositoryFactory) {
            ((org.modeshape.jcr.api.RepositoryFactory)factory).shutdown();
        }
    }
}
