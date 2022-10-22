package com.likelen.identifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;

@ConfigurationProperties(prefix = "id-generator")
public class LongValueGeneratorProperties {

    @Autowired
    private Environment env;

    public String getAggregateId() {
        if (!env.containsProperty("id-generator.aggregateId")) {
            throw new IllegalArgumentException("Not found aggregateId Properties in Application.yml");
        }
        return env.getProperty("id-generator.aggregateId");
    }
}
