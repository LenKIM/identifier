package com.likelen.identifier.core;

public interface StringValueGenerator {

    String gen();

    default String[] genList(int size) {
        return new String[]{gen()};
    }
}
