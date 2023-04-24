package org.example.timing;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Timing {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final StopWatch stopWatch = new StopWatch();

    private Timing() {
        super();
    }

    public static void startTime() {
        stopWatch.start();
        LOGGER.info("Stopwatch Started.");
    }

    public static void endTime() {
        stopWatch.stop();
        LOGGER.info("Stopwatch Stopped.");
    }

    public static void getElapsedTime() {
        LOGGER.info("Time Elapsed: {}ms", stopWatch.getTime());
    }
}
