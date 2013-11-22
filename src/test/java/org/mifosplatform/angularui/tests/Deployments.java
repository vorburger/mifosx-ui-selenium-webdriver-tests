package org.mifosplatform.angularui.tests;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import org.jboss.shrinkwrap.api.ArchivePath;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.Node;
import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class Deployments {

    private static final String FRONT_END_COORDINATES = "org.mifosplatform.angularui:community-app:war:1.0.0-SNAPSHOT";

    public static WebArchive angularFrontEnd() throws IOException {
        WebArchive webArchive = Maven.resolver()
                    .resolve(FRONT_END_COORDINATES)
                    .withoutTransitivity()
                    .as(WebArchive.class)[0];
        return webArchive;
    }

    public static WebArchive angularFrontEndWithAlternativeConfiguration() throws IOException {
        final WebArchive archive = angularFrontEnd();
        new ConfigurationInArchiveReplacer(archive).replace(ImmutableMap.of("API_URL_OVERRIDE", "false"));
        return archive;
    }


}
