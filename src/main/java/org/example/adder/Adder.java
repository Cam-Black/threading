package org.example.adder;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Adder implements Callable<Integer> {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String inFile;

    public Adder(String inFile) {
        super();
        this.inFile = inFile;
    }

    public int doAdd() {
        int total = 0;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inFile))) {
            List<String> lines = br.lines().collect(Collectors.toList());

            if (CollectionUtils.isNotEmpty(lines)) {
                total += lines.size();
            }

        } catch (IOException ioe) {
            LOGGER.error(ioe);
        }
        return total;
    }

    @Override
    public Integer call() {
            return doAdd();
    }
}
