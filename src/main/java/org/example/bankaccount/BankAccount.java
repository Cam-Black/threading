package org.example.bankaccount;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        super();
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
