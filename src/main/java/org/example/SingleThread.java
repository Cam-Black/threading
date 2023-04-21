package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.files.InputFiles;
import org.example.files.OutputFiles;
import org.example.adder.Adder;
import org.example.timing.Timing;

import java.io.IOException;

public class SingleThread {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info("Starting single threaded application!");

        Timing.startTime();
        InputFiles inFiles = new InputFiles();
        OutputFiles outFiles = new OutputFiles();

        try {
            for (int i = 0; i < inFiles.getFiles().length; i++) {
                Adder adder = new Adder(inFiles.getFiles()[i], outFiles.getFiles()[i]);
                adder.doAdd();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Timing.endTime();
        Timing.getElapsedTime();
    }
}