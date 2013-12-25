package ch.vorburger.webdriver.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract Page Object base class.
 *
 * @author Michael Vorburger
 */
public abstract class AbstractPage {

    private static final int TIME_OUT_AFTER_30_S = 30;
    private static final int CHECK_EVERY_100_MS = 100;

    private WebDriver driver;
//    protected final PageProvider pageProvider;

    /**
     * Constructor.
     * This is intentionally public and not just protected,
     * so that Ctrl-1 on sub-classes can conveniently auto-create
     * public constructors in real (non-abstract) *Page classes.
     *
     * @param wd the WebDriver instance
     */
//    public AbstractPage(WebDriver wd) {
//        super();
//        this.wd = wd;
//        this.pageProvider = new PageProvider(wd);
//    }

    public void waitForElementToAppear(final String id) {
        final ExpectedCondition<Boolean> elementAppears = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return !input.findElements(By.id(id)).isEmpty();

            }
        };

        final WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_AFTER_30_S, CHECK_EVERY_100_MS);
        wait.until(elementAppears);
    }

    public WebElement waitForTextToChange(final String id, final String expectedText) {
        final ExpectedCondition<Boolean> elementChangesText = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return input.findElement(By.id(id)).getText().equals(expectedText);
            }
        };

        final WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_AFTER_30_S, CHECK_EVERY_100_MS);
        wait.until(elementChangesText);
        return driver.findElement(By.id(id));
    }
    
    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }
    
    public void setScriptTimeout() {
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }
}