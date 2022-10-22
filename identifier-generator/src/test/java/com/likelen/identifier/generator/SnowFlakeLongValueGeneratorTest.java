package com.likelen.identifier.generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SnowFlakeLongValueGeneratorTest {

    SnowFlakeLongValueGenerator sut;
    Gson gson;
    @BeforeEach
    void setUp() {
        gson = new GsonBuilder().create();
    }

    @Test
    void genTest() {
        long expectedAggregateId = 1L ;
        sut = new SnowFlakeLongValueGenerator(expectedAggregateId);

        long generatedId = sut.gen();

        Map map = gson.fromJson(sut.parse(generatedId), Map.class);
        long actualAggregateId = Long.parseLong(String.valueOf(map.get("workerId")));
        assertThat(expectedAggregateId).isEqualTo(actualAggregateId);
    }
}
