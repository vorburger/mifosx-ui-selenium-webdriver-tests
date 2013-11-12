package org.mifosplatform.angularui.tests.views;

import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.utils.AbstractPage;

public class HomePage extends AbstractPage {

	public final TopNavBarPart navBar;
	
	public HomePage(WebDriver wd) {
		super(wd);
		navBar = pageProvider.newPage(TopNavBarPart.class);
	}

}
