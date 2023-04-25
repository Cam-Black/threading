package org.example;

import org.apache.commons.collections4.CollectionUtils;
import org.example.account.AccountDetails;
import org.example.account.GetAccountDetails;
import org.example.account.GetCustomerAccounts;
import org.example.constants.Customers;
import org.example.customer.Customer;
import org.example.timing.Timing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Timing.startTime();
        ExecutorService es = Executors.newFixedThreadPool(3);
        Customer customer = Customers.getCustomerFromId(1);

        List<Integer> accountIds = GetCustomerAccounts.getAccountIdsFromCustomerId(customer);

        List<Future<AccountDetails>> accountDetailsFutures = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(accountIds)) {
            accountIds.forEach(el -> accountDetailsFutures.add(es.submit(new GetAccountDetails(el))));
        }

        es.shutdown();
        Timing.endTime();
        Timing.getElapsedTime();
    }
}
