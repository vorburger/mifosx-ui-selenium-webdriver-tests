package org.mifosplatform.angularui.tests.views.organization;

import static com.paulhammant.ngwebdriver.WaitForAngularRequestsToFinish.waitForAngularRequestsToFinish;

import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ch.vorburger.webdriver.utils.AbstractPage;

import com.paulhammant.ngwebdriver.ByAngular;

public class EditCurrenciesPage extends AbstractPage {
    
    private WebDriver driver;
    private ByAngular ng;
    
    @ArquillianResource
    private JavascriptExecutor executor;
    
    @FindBy(id =  "new-currency")
    private WebElement newCurrency;
    
    @FindBy(id =  "add-currency")
    private WebElement addCurrency;
    
    @FindBy(id =  "save-currency-config")
    private WebElement saveConfig;
    
    public void init(WebDriver driver) {
        this.driver = driver;
        setWebDriver(driver);
        ng = new ByAngular(executor);
        setScriptTimeout();
        waitForAngularRequestsToFinish(executor);
    }
    
    public void addCurrency(String uniqueCurrencySubstring) {
        newCurrency.sendKeys(uniqueCurrencySubstring);
        waitForAngularRequestsToFinish(executor);
        WebElement firstMatch = driver.findElement(ng.repeater("match in matches"));
        firstMatch.click();
        addCurrency.click();
    }
    
    public void saveConfig() {
        saveConfig.click();
    }

}
