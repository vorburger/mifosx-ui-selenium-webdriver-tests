package ch.vorburger.webdriver.utils;

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

    protected final WebDriver wd;
    protected final PageProvider pageProvider;

    /**
     * Constructor.
     * This is intentionally public and not just protected,
     * so that Ctrl-1 on sub-classes can conveniently auto-create
     * public constructors in real (non-abstract) *Page classes.
     *
     * @param wd the WebDriver instance
     */
    public AbstractPage(WebDriver wd) {
        super();
        this.wd = wd;
        this.pageProvider = new PageProvider(wd);
    }

    public void waitForElementToAppear(final String id) {
        final ExpectedCondition<Boolean> elementAppears = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return !input.findElements(By.id(id)).isEmpty();

            }
        };

        final WebDriverWait wait = new WebDriverWait(wd, TIME_OUT_AFTER_30_S, CHECK_EVERY_100_MS);
        wait.until(elementAppears);
    }

    public WebElement waitForTextToChange(final String id, final String expectedText) {
        final ExpectedCondition<Boolean> elementChangesText = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return input.findElement(By.id(id)).getText().equals(expectedText);
            }
        };

        final WebDriverWait wait = new WebDriverWait(wd, TIME_OUT_AFTER_30_S, CHECK_EVERY_100_MS);
        wait.until(elementChangesText);
        return wd.findElement(By.id(id));
    }
}