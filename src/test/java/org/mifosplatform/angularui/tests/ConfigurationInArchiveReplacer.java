package org.mifosplatform.angularui.tests;

import com.google.common.io.CharStreams;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class ConfigurationInArchiveReplacer {

    private static final String APP_CONFIGURATION_PATH = "app/scripts/modules/configurations.js";

    private final Archive<?> archive;

    public ConfigurationInArchiveReplacer(final Archive<?> archive) {
        this.archive = archive;
    }

    /**
     * Matches configuration entries based on the key and set the new value to the one specified in the passed map.
     *
     * @param newConfig key-value pairs for new configuration
     *
     * @throws IOException
     */
    public void replace(final Map<String,String> newConfig) throws IOException {
        final InputStream stream = new ArchiveInspector(archive).open(APP_CONFIGURATION_PATH);
        if (stream == null) {
            throw new IllegalArgumentException("Input stream to Configuration JS stream not initialized properly. Wrong path? Does it exist?");
        }
        final ConfigurationValuesReplacer configurationReplacer = new ConfigurationValuesReplacer(CharStreams.toString(new InputStreamReader(stream)));
        stream.close();

        for (Map.Entry<String, String> entry : newConfig.entrySet()) {
            configurationReplacer.replace(entry.getKey(), entry.getValue());
        }

        archive.delete(ArchivePaths.create(APP_CONFIGURATION_PATH));
        archive.add(new StringAsset(configurationReplacer.getConfiguration()), ArchivePaths.create(APP_CONFIGURATION_PATH));
    }

}
