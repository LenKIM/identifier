package com.likelen.identifier.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringValueGeneratorTest {

    StringValueGenerator sut;

    @Test
    void genTest() {
        sut = () -> "foo";

        assertThat(sut.gen()).isEqualTo("foo");
    }
}
