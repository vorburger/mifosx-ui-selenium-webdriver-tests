package org.mifosplatform.angularui.tests;

import org.junit.Ignore;
import org.junit.Test;

import ch.vorburger.webdriver.utils.WebDriverTestFixture;

@Ignore
public class LoginTest {

	WebDriverTestFixture fix;
	
	@Test
	public void testCorrectLogin() {
		fix.loginPage.loginAs("mifos", "password");
		// NOTE: We don't assert anything here.
	}

	@Test
	public void testWrongLogin() {
		fix.loginPage.loginAsExpectingError("baduser", "badpwd");
		// NOTE: We don't assert anything here.
	}
}
