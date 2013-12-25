package org.mifosplatform.angularui.tests.views.organization;

import static com.paulhammant.ngwebdriver.WaitForAngularRequestsToFinish.waitForAngularRequestsToFinish;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.paulhammant.ngwebdriver.ByAngular;

import ch.vorburger.webdriver.utils.AbstractPage;

public class CurrencyConfigPage extends AbstractPage {
    
    private WebDriver driver;
    private ByAngular ng;
    
    @FindBy(id =  "edit-currency")
    private WebElement editCurrency;
    
    @ArquillianResource
    private JavascriptExecutor executor;
    
    public void init(WebDriver driver) {
        this.driver = driver;
        ng = new ByAngular(executor);
        setWebDriver(driver);
        setScriptTimeout();
        waitForAngularRequestsToFinish(executor);
    }
    
    public void editCurrencies() {
        editCurrency.click();
    }
    
    public void shouldShowAvailableCurrency(String currency) {
        List<WebElement> allAvailableCurrencies = driver.findElements(ng.binding("currency.name"));
        String matchingCurrencyName = new String();
        for(WebElement currencyName : allAvailableCurrencies) {
            if(currencyName.getText().equals(currency))
                matchingCurrencyName = currencyName.getText();
        }
        assertThat(matchingCurrencyName).isEqualToIgnoringCase(currency);
    }

}
