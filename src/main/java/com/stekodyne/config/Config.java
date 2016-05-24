package com.stekodyne.config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * Created by steffen on 5/21/16.
 *
 * Proxy class used to interface with Apache Commons Configurations.
 *
 * TODO: I would look to extend this using Google's Guice for DI and create a ConfigService instead of passing
 * the config around.
 *
 */
public class Config {
    private Configuration config = null;

    public Config() {
       loadConfig();
    }

    private void loadConfig() {
        try {
            Parameters params = new Parameters();
            FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                    new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                            .configure(params.properties()
                                    .setFileName("papercut.properties"));
            this.config = builder.getConfiguration();
        } catch (ConfigurationException cex) {
            cex.printStackTrace();
        }
    }

    public double getDouble(String property) {
        return config.getDouble(property);
    }

    public String getString(String property) {
        return config.getString(property);
    }
}
