package com.likelen.identifier.core;

import java.util.UUID;

public interface UuidValueGenerator {

    UUID gen();

    default UUID[] genList(int size) {
        return new UUID[]{gen()};
    }
}
