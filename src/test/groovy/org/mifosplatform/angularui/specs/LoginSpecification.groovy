package org.mifosplatform.angularui.specs

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.drone.api.annotation.Drone
import org.jboss.arquillian.spock.ArquillianSputnik
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.runner.RunWith
import org.mifosplatform.angularui.tests.Deployments
import org.mifosplatform.angularui.tests.views.HomePage
import org.mifosplatform.angularui.tests.views.LoginPage
import org.openqa.selenium.WebDriver

import spock.lang.Ignore
import spock.lang.Stepwise

@Stepwise
@RunWith(ArquillianSputnik)
public class LoginSpecification extends AbstractSpecification {

    @Deployment(testable = false) // implies run as client mode
    def static WebArchive "create deployment"() {
        return Deployments.angularFrontEnd()
    } 
  
    URL url 
    
    @Drone
    WebDriver driver
    
    def setup() {
        url = fixUrl()
    }

	@Ignore
	def "Shouldn't be able to login with wrong credentials" () {
		given:
		    def loginPage = new LoginPage(driver, url.toString())
		
		when:
		    loginPage = loginPage.loginAsExpectingError "badid", "badpwd"
			
		then:
		    loginPage.shouldShowAuthenticationError()		
	}

	def "Should be able to login from the main page with proper credentials" () {
        given:
            def loginPage = new LoginPage(driver, url.toString())

        when:
            def homePage = loginPage.loginAs "mifos", "password"

        then:
            homePage.shouldHaveUserMenuFor "mifos"
    }
	
}
