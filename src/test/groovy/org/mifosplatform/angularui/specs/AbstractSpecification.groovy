package org.mifosplatform.angularui.specs

import org.jboss.arquillian.test.api.ArquillianResource
import spock.lang.Specification

abstract class AbstractSpecification extends Specification{
    
    @ArquillianResource
    URL deployedUrl
    
    protected URL fixUrl() {
        String baseApiUrl = System.getProperty("base.url")
        if(baseApiUrl != null && baseApiUrl != "")
            deployedUrl = new URL(deployedUrl.toString() + "app?baseApiUrl=" + baseApiUrl)
        else {
            deployedUrl = new URL(deployedUrl.toString() + "app")
        }
        return deployedUrl
    }

}

