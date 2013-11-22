package org.mifosplatform.angularui.specs

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.drone.api.annotation.Drone
import org.jboss.arquillian.spock.ArquillianSputnik
import org.jboss.arquillian.test.api.ArquillianResource
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.Before
import org.junit.runner.RunWith
import org.mifosplatform.angularui.tests.Deployments
import org.mifosplatform.angularui.tests.views.LoginPage
import org.openqa.selenium.WebDriver

import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
@RunWith(ArquillianSputnik)
public class LoginSpecification extends Specification {

    @Deployment(testable = false) // implies run as client mode
    def static WebArchive "create deployment"() {
        return Deployments.angularFrontEnd()
    } 
	
    @ArquillianResource
    URL deployedFrontEndUrl
  
    @Drone
    WebDriver driver
	
	@Before
	public void fixUrl() {
		String baseApiUrl = System.getProperty("base.url");
		if(baseApiUrl != null && baseApiUrl != "")
		    deployedFrontEndUrl = new URL(deployedFrontEndUrl.toString() + "app?baseApiUrl=" + baseApiUrl)
		else
		    deployedFrontEndUrl = new URL(deployedFrontEndUrl.toString() + "app")
	}

	
	def "Shouldn't be able to login with wrong credentials" () {
		given:
		    def loginPage = new LoginPage(driver, deployedFrontEndUrl.toString())
		
		when:
		    loginPage = loginPage.loginAsExpectingError "badid", "badpwd"
			
		then:
		    loginPage.shouldShowAuthenticationError()		
	}

	    def "Should be able to login from the main page with proper credentials" () {
        given:
            def loginPage = new LoginPage(driver, deployedFrontEndUrl.toString())

        when:
            def homePage = loginPage.loginAs "mifos", "password"

        then:
            homePage.shouldHaveUserMenuFor "mifos"
    }
	
}
