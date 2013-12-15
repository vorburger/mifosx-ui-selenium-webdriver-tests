package org.mifosplatform.angularui.tests.views;

import org.mifosplatform.angularui.tests.views.clients.ClientsPage;
import org.mifosplatform.angularui.tests.views.organization.OrganizationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ch.vorburger.webdriver.utils.AbstractPage;

public class TopNavBarPart extends AbstractPage {

	@FindBy(how=How.CSS, using="[href*='#/createclient']")
	private WebElement clients;
	
	protected TopNavBarPart(WebDriver wd) {
		super(wd);
		waitForElementToAppear("main-menu-left");
		pageProvider.initialize(this);
	}

	public ClientsPage goClients() {
		clients.click();
		return pageProvider.initialize(ClientsPage.class);
	}
	
	public OrganizationPage goToOrganizationPage() {
	    WebDriverWait wait = new WebDriverWait(wd, 300);
	    WebElement adminMenu = wait.until(ExpectedConditions
	                      .visibilityOfElementLocated(By.cssSelector(".dropdown#preview-menu a")));
        //WebElement selectElement = wait.until(elementToBeClickable(By.cssSelector(".dropdown#preview-menu a"))); elementToBeClickable is supposed to work with Ajax calls
        //Check Sleeper in support.ui
	    try{ Thread.sleep(1000);}catch(InterruptedException ie){ }
	    adminMenu.click();
	    WebElement organization = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("[href*='#/organization']")));
	    organization.click();
        return new OrganizationPage(wd);
    }
}
