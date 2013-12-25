package org.mifosplatform.angularui.tests.views;

import static com.paulhammant.ngwebdriver.WaitForAngularRequestsToFinish.waitForAngularRequestsToFinish;

import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ch.vorburger.webdriver.utils.AbstractPage;

public class TopNavBarPart extends AbstractPage {
    
    @FindBy(how=How.CSS, using=".dropdown#preview-menu a")
    private WebElement adminMenu;
    
    @FindBy(how=How.CSS, using="[href*='#/users']")
    private WebElement users;
    
    @FindBy(how=How.CSS, using="[href*='#/organization']")
    private WebElement organization;
    
    @FindBy(how=How.CSS, using="[href*='#/system']")
    private WebElement system;
    
    @FindBy(how=How.CSS, using="[href*='#/products']")
    private WebElement products;
    
    @FindBy(how=How.CSS, using="[href*='#/templates']")
    private WebElement templates;

    @ArquillianResource
    private JavascriptExecutor executor;
	
	public void init(WebDriver driver) {
	    setWebDriver(driver);
	    setScriptTimeout();
	    waitForAngularRequestsToFinish(executor);
	}
	
	public void goToUsersPage() {
        adminMenu.click();
        users.click();
    }
	
	public void goToOrganizationPage() {
	    adminMenu.click();
	    organization.click();
    }
	
	public void goToSystemPage() {
        adminMenu.click();
        system.click();
    }
	
	public void goToProductsPage() {
        adminMenu.click();
        products.click();
    }
	
	public void goToTemplatesPage() {
        adminMenu.click();
        templates.click();
    }
}
