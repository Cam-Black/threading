package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.account.Account;
import org.example.account.GetAccountDetails;
import org.example.account.GetCustomerAccounts;
import org.example.constants.CustomerDetails;
import org.example.customer.Customer;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        Customer customer = CustomerDetails.getCustomerFromId(2);
        List<Integer> accountIds = GetCustomerAccounts.getAccountDetails(customer.getId());
        accountIds.forEach(LOGGER::info);

        List<Account> accountDetailsList = GetAccountDetails.getDetails(accountIds);
        accountDetailsList.forEach(LOGGER::info);
    }
}
