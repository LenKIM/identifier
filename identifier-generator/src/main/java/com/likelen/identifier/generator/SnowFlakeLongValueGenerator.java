package com.likelen.identifier.generator;

import com.likelen.identifier.core.IdGenerateFailException;
import com.likelen.identifier.core.LongValueGenerator;
import com.likelen.identifier.core.Parseable;
import com.littlenb.snowflake.sequence.IdGenerator;
import com.littlenb.snowflake.support.MillisIdGeneratorFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class SnowFlakeLongValueGenerator implements LongValueGenerator, Parseable {

    private final static long INIT_TIME;

    static {
        LocalDateTime ldt = LocalDateTime.of(2022, 1, 1, 1, 1);
        ZonedDateTime ldtZoned = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));
        INIT_TIME = utcZoned.toEpochSecond();
    }

    private final long aggregateId;
    private final IdGenerator idGenerator;

    public SnowFlakeLongValueGenerator(long aggregateId) {
        this.aggregateId = aggregateId;
        idGenerator = new MillisIdGeneratorFactory(INIT_TIME).create(aggregateId);
    }

    @Override
    public long gen() throws IdGenerateFailException {
        return idGenerator.nextId();
    }

    @Override
    public String parse(long id) {
        return idGenerator.parse(id);
    }
}
