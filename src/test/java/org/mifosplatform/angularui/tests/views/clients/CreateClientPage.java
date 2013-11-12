package org.mifosplatform.angularui.tests.views.clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ch.vorburger.webdriver.utils.AbstractPage;

public class CreateClientPage extends AbstractPage {

	// TODO more fields, setters, etc.

	private WebElement firstname;
	
	public CreateClientPage(WebDriver wd) {
		super(wd);
	}

	public void setFirstName(String string) {
		firstname.sendKeys(string);
	}

	public ClientsPage save() {
		// TODO implement me.. define a WebElement for the Save button, use the pageProvider for a new Clients Page..
		return null;
	}
	
	public CreateClientPage saveExpectingError() {
		// TODO implement me.. define a WebElement for the Save button, use the pageProvider for a new Clients Page..
		return this;
	}

}
