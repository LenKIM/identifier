package com.likelen.identifier;

import com.likelen.identifier.core.LongValueGenerator;
import com.likelen.identifier.generator.IdGeneratorFactory;
import com.likelen.identifier.generator.SnowFlakeLongValueGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
@ConditionalOnClass(LongValueGenerator.class)
@EnableConfigurationProperties(LongValueGeneratorProperties.class)
public class LongValueGeneratorAutoConfiguration {

    private final LongValueGeneratorProperties properties;
    private final Environment environment;

    public LongValueGeneratorAutoConfiguration(LongValueGeneratorProperties properties, Environment environment) {
        this.properties = properties;
        this.environment = environment;
    }

    @Bean
    public LongValueGenerator createInstance() {

        IdGeneratorFactory idGeneratorFactory;
        if (Arrays.asList(environment.getActiveProfiles()).contains("production")) {
            long aggregateId = Long.parseLong(properties.getAggregateId());
            idGeneratorFactory = new IdGeneratorFactory(new SnowFlakeLongValueGenerator(aggregateId));
        } else {
            idGeneratorFactory = new IdGeneratorFactory(new DummyLongValueGenerator());
        }
        return idGeneratorFactory.create();
    }

    private static class DummyLongValueGenerator implements LongValueGenerator {
        static final long SOURCE = 10000000;
        static final long BOUND = 99999999;

        @Override
        public long gen() {
            return ThreadLocalRandom.current().nextLong(SOURCE, BOUND);
        }
    }
}
