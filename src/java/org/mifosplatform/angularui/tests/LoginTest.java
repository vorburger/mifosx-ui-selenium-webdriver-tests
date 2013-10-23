package org.mifosplatform.angularui.tests;

import org.junit.Test;

import ch.vorburger.webdriver.utils.WebDriverTestFixture;

public class LoginTest {

	WebDriverTestFixture fix;
	
	@Test
	public void testCorrectLogin() {
		fix.loginPage.loginValidUser("mifos", "password");
		// NOTE: We don't assert anything here.
	}

	@Test
	public void testWrongLogin() {
		fix.loginPage.loginAsExpectingError("baduser", "badpwd");
		// NOTE: We don't assert anything here.
	}
}
