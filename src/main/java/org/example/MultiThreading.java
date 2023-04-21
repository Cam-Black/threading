package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.adder.Adder;
import org.example.files.InputFiles;
import org.example.files.OutputFiles;
import org.example.timing.Timing;

import java.util.Arrays;

public class MultiThreading {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("Starting multi-threaded application");
        Timing.startTime();


        Thread[] threads = new Thread[InputFiles.files.length];

        for (int i = 0; i < InputFiles.files.length; i++) {
            Adder adder = new Adder(InputFiles.files[i], OutputFiles.files[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }

        Arrays.stream(threads).forEach(el -> {
            try {
                el.join();
            } catch (InterruptedException ie) {
                el.interrupt();
            }
        });

        Timing.endTime();
        Timing.getElapsedTime();
    }
}
