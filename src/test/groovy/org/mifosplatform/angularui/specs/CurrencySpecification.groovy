package org.mifosplatform.angularui.specs

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.drone.api.annotation.Drone
import org.jboss.arquillian.graphene.page.Page
import org.jboss.arquillian.spock.ArquillianSputnik
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.runner.RunWith
import org.mifosplatform.angularui.tests.Deployments
import org.mifosplatform.angularui.tests.views.LoginPage
import org.mifosplatform.angularui.tests.views.TopNavBarPart
import org.mifosplatform.angularui.tests.views.organization.CurrencyConfigPage
import org.mifosplatform.angularui.tests.views.organization.EditCurrenciesPage
import org.mifosplatform.angularui.tests.views.organization.OrganizationPage
import org.openqa.selenium.WebDriver

import spock.lang.Stepwise

@Stepwise
@RunWith(ArquillianSputnik)
class CurrencySpecification extends AbstractSpecification {

    @Deployment(testable = false)
    def static WebArchive "create deployment"() {
        return Deployments.angularFrontEnd()
    }
  
    URL url
    
    @Drone
    WebDriver driver
    
    @Page
    private LoginPage loginPage
    
    @Page
    private OrganizationPage orgPage
    
    @Page
    private TopNavBarPart topNavBar
    
    @Page
    private CurrencyConfigPage currConfigPage
    
    @Page
    private EditCurrenciesPage editCurrenciesPage
    
    def setup() {
        url = fixUrl()
    }
    
    def "Add multiple currencies" () {
        given:
             loginPage.init(driver, url.toString())
             loginPage.loginAs "mifos", "password"
             topNavBar.init(driver)
             topNavBar.goToOrganizationPage()
             orgPage.init(driver)
             orgPage.goToCurrencyConfigPage()
             currConfigPage.init(driver)
             currConfigPage.editCurrencies()
             editCurrenciesPage.init(driver)
             
        when:
             editCurrenciesPage.addCurrency("Cz")
             editCurrenciesPage.addCurrency("Lem")
             editCurrenciesPage.saveConfig()
             currConfigPage.init(driver)
             
        then:
             currConfigPage.shouldShowAvailableCurrency("Czech Koruna")
             currConfigPage.shouldShowAvailableCurrency("Honduras Lempira")
    }
}
