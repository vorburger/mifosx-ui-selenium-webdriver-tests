package org.mifosplatform.angularui.tests;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.mifosplatform.angularui.tests.views.HomePage;
import org.mifosplatform.angularui.tests.views.clients.ClientsPage;
import org.mifosplatform.angularui.tests.views.clients.CreateClientPage;
import org.mifosplatform.angularui.tests.views.clients.ViewClientPage;

import ch.vorburger.webdriver.utils.WebDriverTestFixture;

@Ignore
public class ClientsTest {

	// TODO rewrite this as a Groovy Geb Spock test ;) like LoginSpecification.groovy
	
	WebDriverTestFixture fix;

	@Test
	public void testCreateAndLookupClient() {
		HomePage homePage = fix.loginPage.loginAs("mifos", "password");
		ClientsPage clientsPage = homePage.navBar.goClients();
		CreateClientPage createClientPage = clientsPage.createClient();
		createClientPage.setFirstName("TestFirstName");
		clientsPage = createClientPage.save();
		clientsPage = clientsPage.filter("TestFirstName");
		ViewClientPage viewClientPage = clientsPage.goClient(1);
		// TODO looking a little more into   
		assertThat(viewClientPage.getFirstName(), is("TestFirstName"));
	}

}
