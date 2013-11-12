package org.mifosplatform.angularui.tests.views;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ch.vorburger.webdriver.utils.AbstractPage;

public class LoginPage extends AbstractPage {

	// NOTE: The 'uid', 'pwd' & 'loginButton' are HTML id, @see https://code.google.com/p/selenium/wiki/PageFactory  
	// TODO https://github.com/openMF/prototype-app/pull/204
	private WebElement uid;
	private WebElement pwd;
	private WebElement loginButton;
	
	public LoginPage(WebDriver wd) {
		super(wd);
	}

	public HomePage loginValidUser(String uid, String password) {
		doLogin(uid, password);
		// TODO how-to? selenium.waitForPageToLoad("waitPeriod");
		// TODO how-to ensure that we actually indeed are on the HomePage, and no longer the LoginPage?
		return pageProvider.newPage(HomePage.class);
	}

	public LoginPage loginAsExpectingError(String uid, String password) {
		doLogin(uid, password);
		// TODO how-to ensure that we're still on the LoginPage?
		return this;
	}

	private void doLogin(String userName, String password) {
		uid.sendKeys(userName);
		pwd.sendKeys(password);
		loginButton.click();
	}

}