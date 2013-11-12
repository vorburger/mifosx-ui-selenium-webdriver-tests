package org.mifosplatform.angularui.tests.views;

import org.mifosplatform.angularui.tests.views.clients.ClientsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ch.vorburger.webdriver.utils.AbstractPage;

public class TopNavBarPart extends AbstractPage {

	// TODO ??? @FindBy(how=How.CSS, using="[href*='#/createclient']")
	private WebElement clients;
	
	protected TopNavBarPart(WebDriver wd) {
		super(wd);
	}

	public ClientsPage goClients() {
		clients.click();
		return pageProvider.initialize(ClientsPage.class);
	}
}
