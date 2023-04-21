package org.example.adder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Adder implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String inFile;
    private final String outFile;

    public Adder(String inFile, String outFile) {
        super();
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void doAdd() throws IOException {
        long total = 0;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(inFile))) {
            while (br.readLine() != null) {
                total += br.lines().count();
            }
        }
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(outFile))) {
            bw.write("Total: " + total);
        }
    }

    @Override
    public void run() {
        try {
            doAdd();
        } catch (IOException ioe) {
            LOGGER.error(ioe);
        }
    }
}
