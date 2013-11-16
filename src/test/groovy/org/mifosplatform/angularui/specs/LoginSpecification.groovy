package org.mifosplatform.angularui.specs

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.drone.api.annotation.Drone
import org.jboss.arquillian.spock.ArquillianSputnik
import org.jboss.arquillian.test.api.ArquillianResource
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.runner.RunWith
import org.mifosplatform.angularui.tests.Deployments
import org.mifosplatform.angularui.tests.views.LoginPage
import org.openqa.selenium.WebDriver
import spock.lang.Specification


@RunWith(ArquillianSputnik)
public class LoginSpecification extends Specification {

    @Deployment(testable = false) // implies run as client mode
    def static WebArchive "create deployment"() {
        return Deployments.angularFrontEnd();
    } 
	
    @ArquillianResource
    URL deployedFrontEndUrl

    @Drone
    WebDriver driver

    def "Should be able to login from the main page with proper credentials" () {
        given:
            def loginPage = new LoginPage(driver, deployedFrontEndUrl.toString() + "app")

        when:
            def homePage = loginPage.loginAs "mifos", "password"

        then:
            homePage.shouldHaveUserMenuFor "mifos"
    }

	// TODO def "Should not be able to login from the main page with wrong credentials" () {
	// use e.g. USE E.G. loginPage.loginAs "baduser", "badpwd" 
	
}