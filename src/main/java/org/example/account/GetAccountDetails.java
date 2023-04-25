package org.example.account;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.constants.Accounts;

import java.util.List;
import java.util.stream.Collectors;

public class GetAccountDetails {
    private static final Logger LOGGER = LogManager.getLogger();

    private GetAccountDetails() {
        super();
    }

    public static List<AccountDetails> getDetails(List<Integer> accountIds) {
        List<AccountDetails> accounts = Accounts.getAccounts();

        LOGGER.info("Retrieving Account Details for Account IDs: {}", accountIds);

        List<AccountDetails> accountDetails = accounts.stream()
                        .filter(el -> accountIds
                                        .stream()
                                        .anyMatch(el2 -> el2 == el.getId()))
                        .collect(Collectors.toList());

        LOGGER.info("Account Details retrieved: {}", accountDetails);
        return accountDetails;
    }
}
