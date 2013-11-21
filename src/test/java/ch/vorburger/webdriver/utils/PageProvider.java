package ch.vorburger.webdriver.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Provider (Factory) for Page Objects. 
 * 
 * This is based on the core WebDriver PageFactory,
 * with the following additions:
 * 
 * <ul><li>TBD ;-)</li></ul>
 * 
 * @author Michael Vorburger
 */
public class PageProvider {

	// TODO @Inject
	private final WebDriver wd;
	
	public PageProvider(WebDriver wd) {
		this.wd = wd;
	}

	public <T> T initialize(Class<T> pageClass) {
		return PageFactory.initElements(wd, pageClass);
	}

    public <T> void initialize(T instance) {
        PageFactory.initElements(wd, instance);
    }
}
