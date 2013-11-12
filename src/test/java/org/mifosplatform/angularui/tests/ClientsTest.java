package org.mifosplatform.angularui.tests;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import org.mifosplatform.angularui.tests.views.HomePage;
import org.mifosplatform.angularui.tests.views.clients.ClientsPage;
import org.mifosplatform.angularui.tests.views.clients.CreateClientPage;
import org.mifosplatform.angularui.tests.views.clients.ViewClientPage;

import ch.vorburger.webdriver.utils.WebDriverTestFixture;

@Ignore
public class ClientsTest {

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
