package org.mifosplatform.angularui.tests.views;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ch.vorburger.webdriver.utils.AbstractPage;

public class HomePage extends AbstractPage {

	public TopNavBarPart navBar;

	public HomePage(WebDriver wd) {
		super(wd);
        pageProvider.initialize(this);
//		navBar = pageProvider.initialize(TopNavBarPart.class);
	}

    public HomePage shouldHaveUserMenuFor(String username) {
        WebElement userDropdown = waitForTextToChange("user-dropdown", username);
        assertThat(userDropdown.getText()).isEqualTo(username);
        return this;
    }

}
