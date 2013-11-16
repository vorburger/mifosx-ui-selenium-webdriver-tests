mifosx-ui-selenium-webdriver-tests
==================================

Mifos X Open Source Microfinance Platform AngularJS UI Selenium WebDriver Tests.

mvn clean test will fire up the Mifos X community-app, a static AngularJS SPA,
in a Jetty on localhost using http://arquillian.org, and then runs web tests against it.

You will have to first install the community-app WAR via 'gradle install' (in community-app).

Because we're programmatically changing community-app/app/scripts/modules/configurations.js
in org.mifosplatform.angularui.tests.Deployments.angularFrontEnd(), the UI will, by default, be
configured on the fly to connect to the Mifos X platform REST API running in the cloud.

If you want to test local changes made to the back-end running on localhost and not yet deployed to the cloud test instance,
please contribute a patch via pull request ;-) so that Deployments.angularFrontEnd() can be configured to make
the UI use different API URLs (specified e.g. via a -D Java system property set in a Launcher?).

To use in Eclipse, you'll need http://groovy.codehaus.org/Eclipse+Plugin.
