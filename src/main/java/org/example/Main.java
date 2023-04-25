package org.example;

import org.example.bankaccount.BankAccount;
import org.example.bankaccount.Worker;
import org.example.timing.Timing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Timing.startTime();

        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(100);

        for (int i = 0; i < 5; i++) {
            es.submit(new Worker(account));
        }

        try {
            es.shutdown();
            if (es.awaitTermination(60, TimeUnit.SECONDS)) {
                Timing.endTime();
                Timing.getElapsedTime();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}