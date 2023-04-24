package org.example.bankaccount;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        super();
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }
}
