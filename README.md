mifosx-ui-selenium-webdriver-tests
==================================

Mifos X Open Source Microfinance Platform AngularJS UI Selenium WebDriver Tests.

mvn clean test will fire up the Mifos X community-app, a static AngularJS SPA,
in a Jetty on localhost using http://arquillian.org, and then runs web tests against it.

You will have to first install the community-app WAR via 'gradle install' (in community-app).

By default, this project currently just runs community-app WAR "as is",
which is configured in community-app/app/scripts/initialTasks.js to connect to the Mifos X platfor
REST API running in the cloud (e.g. https://demo.openmf.org/mifosng-provider/api/v1/clients/?tenantIdentifier=default&pretty=true).

If you want to test local changes made to the back-end running on localhost and not yet deployed to the cloud test instance,
the tests can be configured to make the UI use different API URLs via a -Dbase.url=... Java system property set
that is passed on into the AngularJS App via the ?baseApiUrl= URL query parameter.

To use in Eclipse, you'll need http://groovy.codehaus.org/Eclipse+Plugin.

This project uses Code Formatting conventions as per https://github.com/jboss/ide-config.

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/vorburger/mifosx-ui-selenium-webdriver-tests/trend.png)](https://bitdeli.com/free "Bitdeli Badge")
