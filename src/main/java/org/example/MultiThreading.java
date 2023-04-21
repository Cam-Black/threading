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
        InputFiles inFiles = new InputFiles();
        OutputFiles outFiles = new OutputFiles();
        Thread[] threads = new Thread[inFiles.getFiles().length];

        for (int i = 0; i < inFiles.getFiles().length; i++) {
            Adder adder = new Adder(inFiles.getFiles()[i], outFiles.getFiles()[i]);
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
