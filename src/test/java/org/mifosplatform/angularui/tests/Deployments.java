package org.mifosplatform.angularui.tests;

import java.io.IOException;

import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.mifosplatform.angularui.tests.utils.ConfigurationInArchiveReplacer;

import com.google.common.collect.ImmutableMap;

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
