package org.mifosplatform.angularui.tests.views.clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ch.vorburger.webdriver.utils.AbstractPage;

public class ClientsPage extends AbstractPage {

	@FindBy(how=How.CSS, using="[href*='#/createclient']")
	private WebElement createClient;

	public ClientsPage(WebDriver wd) {
		super(wd);
	}

	public CreateClientPage createClient() {
		createClient.click();
		return pageProvider.newPage(CreateClientPage.class);
	}

	public ClientsPage filter(String nameAcctNoStaffOffice) {
		// TODO implement me.. define a WebElement for the Filter box, type into it, make sure the list gets updated, etc.
		return this;
	}

	public ViewClientPage goClient(int i) {
		// TODO implement me.. define a WebElement for the list box, and click on row i
		return null;
	}
}
