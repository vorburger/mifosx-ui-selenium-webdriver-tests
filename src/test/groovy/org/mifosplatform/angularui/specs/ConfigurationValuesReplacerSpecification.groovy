package org.mifosplatform.angularui.specs

import static org.assertj.core.api.Assertions.assertThat

import org.mifosplatform.angularui.tests.utils.ConfigurationValuesReplacer

import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class ConfigurationValuesReplacerSpecification extends Specification {

    def "should replace api url definition"() {
        given:
            String initialConfig = "angular.module('configurations', [])\n" +
                    ".constant('API_URL_OVERRIDE', 'false')\n" +
                    ".constant('TENANT','default')\n" +
                    ".constant('HOST','https://demo.openmf.org')\n" +
                    ".constant('API_VERSION','/mifosng-provider/api/v1')\n" +
                    ".constant('CONTENT_TYPE','application/json; charset=utf-8');"

            String expectedConfig = "angular.module('configurations', [])\n" +
                    ".constant('API_URL_OVERRIDE', 'true')\n" +
                    ".constant('TENANT','default')\n" +
                    ".constant('HOST','https://demo.openmf.org')\n" +
                    ".constant('API_VERSION','/mifosng-provider/api/v1')\n" +
                    ".constant('CONTENT_TYPE','application/json; charset=utf-8');"

            def configurationValuesReplacer = new ConfigurationValuesReplacer(initialConfig)

        when:
            configurationValuesReplacer.replace("API_URL_OVERRIDE", "true")

        then:
            assertThat(configurationValuesReplacer.getConfiguration()).isEqualTo(expectedConfig)
    }

    def "Should replace api url and tenant"() {
        given:
            def initialConfig = "angular.module('configurations', [])\n" +
                    ".constant('API_URL_OVERRIDE', 'false')\n" +
                    ".constant('TENANT','default' )\n" +
                    ".constant('HOST','https://demo.openmf.org')\n" +
                    ".constant('API_VERSION','/mifosng-provider/api/v1')\n" +
                    ".constant('CONTENT_TYPE','application/json; charset=utf-8');"

            def expectedConfig = "angular.module('configurations', [])\n" +
                    ".constant('API_URL_OVERRIDE', 'true')\n" +
                    ".constant('TENANT', 'prod')\n" +
                    ".constant('HOST','https://demo.openmf.org')\n" +
                    ".constant('API_VERSION','/mifosng-provider/api/v1')\n" +
                    ".constant('CONTENT_TYPE','application/json; charset=utf-8');"

            def configurationValuesReplacer = new ConfigurationValuesReplacer(initialConfig)

        when:
            configurationValuesReplacer.replace("API_URL_OVERRIDE", "true")
            configurationValuesReplacer.replace("TENANT", "prod")

        then:
            assertThat(configurationValuesReplacer.getConfiguration()).isEqualTo(expectedConfig)
    }
}
