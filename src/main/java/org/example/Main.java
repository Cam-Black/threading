package org.example;

import org.apache.commons.collections4.CollectionUtils;
import org.example.account.GetAccountDetails;
import org.example.account.GetCustomerAccounts;
import org.example.constants.Customers;
import org.example.customer.Customer;
import org.example.timing.Timing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Timing.startTime();

        Customer customer = Customers.getCustomerFromId(1);

        List<Integer> accountIds = GetCustomerAccounts.getAccountIdsFromCustomerId(customer);

        if (CollectionUtils.isNotEmpty(accountIds)) {
            GetAccountDetails.getDetails(accountIds);
        }

        Timing.endTime();
        Timing.getElapsedTime();
    }
}
