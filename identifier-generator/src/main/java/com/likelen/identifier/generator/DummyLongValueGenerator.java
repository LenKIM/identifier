package com.likelen.identifier.generator;

import com.likelen.identifier.core.LongValueGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class DummyLongValueGenerator implements LongValueGenerator {
    static final long SOURCE = 10000000;
    static final long BOUND = 99999999;

    @Override
    public long gen() {
        return ThreadLocalRandom.current().nextLong(SOURCE, BOUND);
    }
}
