package org.mifosplatform.angularui.tests;

import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class Deployments {

    private static final String FRONT_END_COORDINATES = "org.mifosplatform.angularui:community-app:war:1.0.0-SNAPSHOT";


    public static WebArchive angularFrontEnd() {
        return Maven.resolver()
                    .resolve(FRONT_END_COORDINATES)
                    .withoutTransitivity()
                    .as(WebArchive.class)[0];
    }
}
