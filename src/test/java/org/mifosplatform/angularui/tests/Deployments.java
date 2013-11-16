package org.mifosplatform.angularui.tests;

import java.io.InputStream;

import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.Node;
import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class Deployments {

    private static final String FRONT_END_COORDINATES = "org.mifosplatform.angularui:community-app:war:1.0.0-SNAPSHOT";


    public static WebArchive angularFrontEnd() {
        WebArchive webArchive = Maven.resolver()
                    .resolve(FRONT_END_COORDINATES)
                    .withoutTransitivity()
                    .as(WebArchive.class)[0];
        Node node = webArchive.get(ArchivePaths.create("app/scripts/modules/configurations.js"));
        Asset asset = node.getAsset();
        InputStream is = asset.openStream();
        // TODO OK, so how do you know change .constant('API_URL_OVERRIDE' to true using the Arquillian API ?? 
        return webArchive;
    }
}
