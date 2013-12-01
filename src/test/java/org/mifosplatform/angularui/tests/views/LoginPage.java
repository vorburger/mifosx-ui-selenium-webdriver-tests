package org.mifosplatform.angularui.tests.views;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ch.vorburger.webdriver.utils.AbstractPage;

public class LoginPage extends AbstractPage {

    @FindBy(id =  "uid")
	private WebElement userNameField;

    @FindBy(id = "pwd")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;
	
	public LoginPage(WebDriver wd, String location) {
        super(wd);
        wd.get(location);
        waitForElementToAppear("uid");
        pageProvider.initialize(this);
	}

    public HomePage loginAs(String username, String password) {
		login(username, password);
		// TODO how-to ensure that we actually indeed are on the HomePage, and no longer the LoginPage?
		return new HomePage(wd);
	}

	public LoginPage loginAsExpectingError(String uid, String password) {
		login(uid, password);
		// TODO how-to ensure that we're still on the LoginPage?
		return this;
	}

	private void login(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	public LoginPage shouldShowAuthenticationError() {
        WebElement errorBox = waitForTextToChange("error", "Please try again, your credentials are not valid");
        assertThat(errorBox.getText()).isEqualTo("Please try again, your credentials are not valid");
        return this;
    }

}