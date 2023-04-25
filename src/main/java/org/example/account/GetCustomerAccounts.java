package org.example.account;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.constants.Accounts;
import org.example.constants.Customers;
import org.example.customer.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class GetCustomerAccounts {
    private static final Logger LOGGER = LogManager.getLogger();
    private GetCustomerAccounts() {
        super();
    }

    public static List<Integer> getAccountIdsFromCustomerId(int id) {
        List<Account> accounts = Accounts.getAccounts();
        Customer customer = Customers.getCustomerFromId(id);

        LOGGER.info("Retrieving Account IDs for Customer: {}", customer);

        return accounts.stream()
                        .filter(el -> el.getCustomer().getId() == customer.getId())
                        .map(Account::getId)
                        .collect(Collectors.toList());
    }
}
