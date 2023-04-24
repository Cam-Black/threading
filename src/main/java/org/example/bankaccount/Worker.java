package org.example.bankaccount;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Worker implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger();
    private final BankAccount account;

    public Worker(BankAccount account) {
        super();
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int startBalance = account.getBalance();
            LOGGER.info("Start Balance: {}", startBalance);
            account.deposit(10);
            int endBalance = account.getBalance();
            LOGGER.info("End Balance: {}", endBalance);
        }
    }
}
