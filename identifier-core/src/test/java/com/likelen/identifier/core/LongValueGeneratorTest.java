package com.likelen.identifier.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LongValueGeneratorTest {

    LongValueGenerator sut;

    @Test
    void gen() {
        sut = () -> 1L;

        assertThat(sut.gen()).isEqualTo(1L);
    }

    @Test
    void throwExceptionTest() {
        sut = () -> {
            throw new IdGenerateFailException();
        };

        assertThatThrownBy(() -> sut.gen()).isInstanceOf(IdGenerateFailException.class);
    }


}
