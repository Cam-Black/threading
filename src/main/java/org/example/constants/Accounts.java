package org.example.constants;

import org.example.account.Account;

import java.util.Arrays;
import java.util.List;

public class Accounts {
    private Accounts() {
        super();
    }
    public static final Account accountOne = new Account(1, Customers.customerOne, "2001-07-20", "Mortgage");
    public static final Account accountTwo = new Account(2, Customers.customerOne, "1995-05-17", "Credit Card");
    public static final Account accountThree = new Account(3, Customers.customerOne, "1994-03-16", "Current Account");

    public static final Account accountFour = new Account(4, Customers.customerTwo, "1980-01-01", "Mortgage");
    public static final Account accountFive = new Account(5, Customers.customerTwo, "1975-08-18", "Current Account");

    public static List<Account> getAccounts() {
        return Arrays.asList(accountOne, accountTwo, accountThree, accountFour, accountFive);
    }
}
