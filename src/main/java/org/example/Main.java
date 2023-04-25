package org.example;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.account.Account;
import org.example.account.GetAccountDetails;
import org.example.account.GetCustomerAccounts;
import org.example.constants.Customers;
import org.example.customer.Customer;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        Customer customer = Customers.getCustomerFromId(1);
        LOGGER.info(customer);

        List<Integer> accountIds = GetCustomerAccounts.getAccountIdsFromCustomerId(customer.getId());
        accountIds.forEach(el -> LOGGER.info("Found Account ID: {}", el));

        if (CollectionUtils.isNotEmpty(accountIds)) {
            List<Account> accountDetailsList = GetAccountDetails.getDetails(accountIds);
            accountDetailsList.forEach(LOGGER::info);
        } else {
            LOGGER.warn("No accounts found for Customer: {}", customer);
        }
    }
}
