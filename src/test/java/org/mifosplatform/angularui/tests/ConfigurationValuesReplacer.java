package org.mifosplatform.angularui.tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigurationValuesReplacer {

    private static final String KEY_VALUE_REGEX = "constant\\(('%1$s')(\\s*),(\\s*)'([^']*)'(\\s*)\\)";

    private String configuration;

    public ConfigurationValuesReplacer(String configuration) {
        this.configuration = configuration;
    }

    public void replace(String key, String newValue) {
        final Matcher m = Pattern.compile(String.format(KEY_VALUE_REGEX, key)).matcher(configuration);
        final StringBuffer sb = new StringBuffer(configuration.length());

        if (m.find()) {
            m.appendReplacement(sb, "constant($1, '" + newValue + "')").appendTail(sb);
        } else {
            sb.append(configuration);
        }

        configuration = sb.toString();
    }

    public String getConfiguration() {
        return configuration;
    }
}
