package com.pt.teacher.helper.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Purpose:-This is util class will generate the random UUID
 *
 * @author Priyanshu Raj
 * @version 1.0
 * @since   2019-07-28
 */
@Component
public class UuidGenerator {

    private static final Logger Logger= LoggerFactory.getLogger(UuidGenerator.class);

    public UUID getUuid()
    {
        Logger.info("Executing CUuidGenerator.getUuid() to get Random UUID");
        UUID uuid=UUID.randomUUID();
        Logger.info("Returning the Random UUID from UuidGenerator.getUuid()");
        return uuid;
    }
}
