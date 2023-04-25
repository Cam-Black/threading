package org.example.constants;

import org.example.account.AccountDetails;

import java.util.Arrays;
import java.util.List;

public class Accounts {
    private Accounts() {
        super();
    }
    public static final AccountDetails
                    ACCOUNT_DETAILS_ONE = new AccountDetails(1, Customers.customerOne, "2001-07-20", "Mortgage");
    public static final AccountDetails
                    ACCOUNT_DETAILS_TWO = new AccountDetails(2, Customers.customerOne, "1995-05-17", "Credit Card");
    public static final AccountDetails
                    ACCOUNT_DETAILS_THREE = new AccountDetails(3, Customers.customerOne, "1994-03-16", "Current Account");

    public static final AccountDetails
                    ACCOUNT_DETAILS_FOUR = new AccountDetails(4, Customers.customerTwo, "1980-01-01", "Mortgage");
    public static final AccountDetails
                    ACCOUNT_DETAILS_FIVE = new AccountDetails(5, Customers.customerTwo, "1975-08-18", "Current Account");

    public static List<AccountDetails> getAccounts() {
        return Arrays.asList(ACCOUNT_DETAILS_ONE, ACCOUNT_DETAILS_TWO, ACCOUNT_DETAILS_THREE, ACCOUNT_DETAILS_FOUR,
                        ACCOUNT_DETAILS_FIVE);
    }
}
