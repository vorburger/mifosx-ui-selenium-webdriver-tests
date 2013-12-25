package org.mifosplatform.angularui.tests.views.organization;

import static com.paulhammant.ngwebdriver.WaitForAngularRequestsToFinish.waitForAngularRequestsToFinish;

import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ch.vorburger.webdriver.utils.AbstractPage;

public class OrganizationPage extends AbstractPage {
    
    @FindBy(how=How.CSS, using="[href*='#/offices']")
    private WebElement offices;
    
    @FindBy(how=How.CSS, using="[href*='#/holidays']")
    private WebElement holidays;
    
    @FindBy(how=How.CSS, using="[href*='#/employees']")
    private WebElement employees;
    
    @FindBy(how=How.CSS, using="[href*='#/currconfig']")
    private WebElement currencyConfig;
    
    @FindBy(how=How.CSS, using="[href*='#/managefunds']")
    private WebElement manageFunds;
    
    @FindBy(how=How.CSS, using="[href*='#/bulkloan']")
    private WebElement bulkLoan;
    
    @ArquillianResource
    private JavascriptExecutor executor;
    
    public void init(WebDriver driver) {
        setWebDriver(driver);
        setScriptTimeout();
        waitForAngularRequestsToFinish(executor);
    }
    
    public void goToOfficesPage() {
        offices.click();
    }
    
    public void goToHolidaysPage() {
        holidays.click();
    }
    
    public void goToEmployeesPage() {
        employees.click();
    }

    public void goToCurrencyConfigPage() {
        currencyConfig.click();
    }

    public void goToManageFundsPage() {
        manageFunds.click();
    }

    public void goToBulkLoanPage() {
        bulkLoan.click();
    }

}
