package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.adder.Adder;
import org.example.files.InputFiles;
import org.example.timing.Timing;

import java.util.Arrays;
import java.util.concurrent.*;

public class CallableFuture {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("Starting multi-threaded application");
        Timing.startTime();

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<?>[] results = new Future[InputFiles.getFilesLength()];

        for (int i = 0; i < InputFiles.getFilesLength(); i++) {
            Adder adder = new Adder(InputFiles.getFile(i));
            results[i] = es.submit(adder);
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

        Arrays.stream(results).forEach(el -> {
            try {
                LOGGER.info("Total: {}", el.get());
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.error(e);
                Thread.currentThread().interrupt();
            }
        });
    }
}
