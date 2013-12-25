package org.mifosplatform.angularui.specs

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.drone.api.annotation.Drone
import org.jboss.arquillian.graphene.page.Page
import org.jboss.arquillian.spock.ArquillianSputnik
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.runner.RunWith
import org.mifosplatform.angularui.tests.Deployments
import org.mifosplatform.angularui.tests.views.HomePage
import org.mifosplatform.angularui.tests.views.LoginPage
import org.openqa.selenium.WebDriver

import spock.lang.Ignore
import spock.lang.Stepwise

@Ignore
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
    
    @Page
    private LoginPage loginPage
    
    @Page
    private HomePage homePage
    
    def setup() {
        url = fixUrl()
    }
    
    def "Shouldn't be able to login with wrong credentials" () {
            given:
                loginPage.init(driver, url.toString())
            
            when:
                loginPage.loginAsExpectingError "badid", "badpwd"
                    
            then:
                loginPage.shouldShowAuthenticationError()
    }

	def "Should be able to login from the main page with proper credentials" () {
        given:
            loginPage.init(driver, url.toString())

        when:
            loginPage.loginAs "mifos", "password"
            homePage.init(driver)

        then:
            homePage.shouldHaveUserMenuFor "mifos"
    }
	
}
