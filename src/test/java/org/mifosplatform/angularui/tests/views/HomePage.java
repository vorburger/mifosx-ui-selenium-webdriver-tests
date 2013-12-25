package org.mifosplatform.angularui.tests.views;

import static com.paulhammant.ngwebdriver.WaitForAngularRequestsToFinish.waitForAngularRequestsToFinish;
import static org.assertj.core.api.Assertions.assertThat;

import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ch.vorburger.webdriver.utils.AbstractPage;

public class HomePage extends AbstractPage {

    @ArquillianResource
    JavascriptExecutor executor;
    
    @FindBy(id =  "user-dropdown")
    private WebElement userDropdown;
	
	public void init(WebDriver driver) {
	    setWebDriver(driver);
	    setScriptTimeout();
        waitForAngularRequestsToFinish(executor);
	}

    public void shouldHaveUserMenuFor(String username) {
        assertThat(userDropdown.getText()).isEqualTo(username);
    }

}
