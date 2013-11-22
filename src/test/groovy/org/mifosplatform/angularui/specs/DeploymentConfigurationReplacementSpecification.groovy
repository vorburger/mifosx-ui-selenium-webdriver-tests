package org.mifosplatform.angularui.specs

import com.google.common.io.CharStreams
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.mifosplatform.angularui.tests.ArchiveInspector
import org.mifosplatform.angularui.tests.Deployments
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

class DeploymentConfigurationReplacementSpecification extends Specification {

    def "Should replace configuration.js with API_URL_OVERRIDE set to false"() throws IOException {
        given:
            def expectedConfig = "angular.module('configurations', [])\n" +
                    ".constant('API_URL_OVERRIDE', 'false')\n" +
                    ".constant('TENANT','default')\n" +
                    ".constant('HOST','https://demo.openmf.org')\n" +
                    ".constant('API_VERSION','/mifosng-provider/api/v1')\n" +
                    ".constant('CONTENT_TYPE','application/json; charset=utf-8');"

            def archive = Deployments.angularFrontEndWithAlternativeConfiguration();

        when:
            def configuration = CharStreams.toString(new InputStreamReader(new ArchiveInspector(archive).open("app/scripts/modules/configurations.js")))

        then:
            assertThat(configuration.trim()).isEqualTo(expectedConfig.trim())

    }
    
}
