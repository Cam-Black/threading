package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.adder.Adder;
import org.example.files.InputFiles;
import org.example.files.OutputFiles;
import org.example.timing.Timing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreading {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("Starting multi-threaded application");
        Timing.startTime();

        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i < InputFiles.getFilesLength(); i++) {
            Adder adder = new Adder(InputFiles.getFile(i), OutputFiles.getFile(i));
            es.submit(adder);
        }

        try {
            es.shutdown();
            if (es.awaitTermination(60, TimeUnit.SECONDS)) {
                Timing.endTime();
                Timing.getElapsedTime();
            }
        } catch (InterruptedException ie) {
            LOGGER.error(ie);
            Thread.currentThread().interrupt();
        }
    }
}
