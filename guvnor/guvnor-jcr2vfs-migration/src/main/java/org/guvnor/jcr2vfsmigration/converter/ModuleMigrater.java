package org.guvnor.jcr2vfsmigration.converter;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ModuleMigrater {

    protected static final Logger logger = LoggerFactory.getLogger(ModuleMigrater.class);

    public void migrateAll() {
        logger.info("  Module migration started");
        // TODO
        logger.info("  Module migration ended");
    }

}
