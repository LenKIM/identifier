package com.likelen.identifier.core;

public interface LongValueGenerator {

    long gen() throws IdGenerateFailException;

    default long[] genList(int size) {
        return new long[]{gen()};
    }
}
