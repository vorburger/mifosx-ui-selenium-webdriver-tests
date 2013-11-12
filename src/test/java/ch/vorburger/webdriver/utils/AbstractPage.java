package ch.vorburger.webdriver.utils;

import org.openqa.selenium.WebDriver;

/**
 * Abstract Page Object base class.
 * 
 * @author Michael Vorburger
 */
public abstract class AbstractPage {

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

}