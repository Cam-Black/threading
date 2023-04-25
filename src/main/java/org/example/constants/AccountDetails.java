package org.example.constants;

import org.example.account.Account;

import java.util.Arrays;
import java.util.List;

public class AccountDetails {
    private AccountDetails() {
        super();
    }
    public static final Account accountOne = new Account(1, CustomerDetails.customerOne, "2001-07-20", "Mortgage");
    public static final Account accountTwo = new Account(2, CustomerDetails.customerOne, "1995-05-17", "Credit Card");
    public static final Account accountThree = new Account(3, CustomerDetails.customerOne, "1994-03-16", "Current Account");

    public static final Account accountFour = new Account(4, CustomerDetails.customerTwo, "1980-01-01", "Mortgage");
    public static final Account accountFive = new Account(5, CustomerDetails.customerTwo, "1975-08-18", "Current Account");

    public static List<Account> getAccounts() {
        return Arrays.asList(accountOne, accountTwo, accountThree, accountFour, accountFive);
    }
}
