package org.example.account;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.constants.Accounts;
import org.example.customer.Customer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GetCustomerAccounts {
    private static final Logger LOGGER = LogManager.getLogger();
    private GetCustomerAccounts() {
        super();
    }

    public static List<Integer> getAccountIdsFromCustomerId(Customer customer) {
        if (customer.getId() == 0) {
            return Collections.emptyList();
        }

        List<AccountDetails> accountDetails = Accounts.getAccounts();

        LOGGER.info("Retrieving Account IDs for Customer: {}", customer);

        List<Integer> accountIds = accountDetails.stream()
                        .filter(el -> el.getCustomer().getId() == customer.getId())
                        .map(AccountDetails::getId)
                        .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(accountIds)) {
            LOGGER.warn("No accounts found for Customer: {}", customer);
            return Collections.emptyList();
        } else {
            LOGGER.info("Account IDs found: {}", accountIds);
            return accountIds;
        }
    }
}
