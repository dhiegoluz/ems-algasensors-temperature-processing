package com.diego.algasensors.temperature.processing;

import com.diego.algasensors.temperature.processing.common.IdGenerator;
import com.diego.algasensors.temperature.processing.common.UUIDv7Utils;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UUIDv7Test {

    @Test
    void shouldGenerateUUIDv7(){

        UUID uuid = IdGenerator.generateTimeBasedUUID();
        UUID uuid2 = IdGenerator.generateTimeBasedUUID();
        UUID uuid3 = IdGenerator.generateTimeBasedUUID();
        UUID uuid4 = IdGenerator.generateTimeBasedUUID();
        UUID uuid5 = IdGenerator.generateTimeBasedUUID();

        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid));
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid2));
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid3));
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid4));
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid5));
    }
}
