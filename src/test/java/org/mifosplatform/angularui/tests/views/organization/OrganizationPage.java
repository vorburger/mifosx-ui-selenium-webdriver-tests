package org.mifosplatform.angularui.tests.views.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ch.vorburger.webdriver.utils.AbstractPage;

public class OrganizationPage extends AbstractPage {
    
    @FindBy(how=How.CSS, using="[href*='#/currconfig']")
    private WebElement currencyConfig;
    
    public OrganizationPage(WebDriver wd) {
        super(wd);
        pageProvider.initialize(this);
    }

}
