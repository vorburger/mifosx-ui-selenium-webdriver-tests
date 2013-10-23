package org.mifosplatform.angularui.tests.views.clients;

import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.utils.AbstractPage;

public class ViewClientPage extends AbstractPage {

	public ViewClientPage(WebDriver wd) {
		super(wd);
	}

	public String getFirstName() {
		// TODO WebDriverElement for FN etc. fields - once they have IDs! ;)
		return null;
	}

}
