package ch.vorburger.webdriver.utils;

import org.mifosplatform.angularui.tests.views.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTestFixture {

	// TODO later I'll switch this to use my webdriver-runner stuff instead of hard-coding like this:
	WebDriver wd = new FirefoxDriver();
	
	// TODO later I'll build some infra. for getting the initial page, resetting back to it @AfterTest, etc.
	public LoginPage loginPage = new PageProvider(wd).newPage(LoginPage.class);

}
