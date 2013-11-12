package org.mifosplatform.angularui.tests.views;

import static org.assertj.core.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ch.vorburger.webdriver.utils.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
