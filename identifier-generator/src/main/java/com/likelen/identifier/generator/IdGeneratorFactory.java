package com.likelen.identifier.generator;

import com.likelen.identifier.core.LongValueGenerator;

public class IdGeneratorFactory {

    private final LongValueGenerator longValueGenerator;

    public IdGeneratorFactory(LongValueGenerator longValueGenerator) {
        this.longValueGenerator = longValueGenerator;
    }

    public LongValueGenerator create() {
        return longValueGenerator;
    }
}
