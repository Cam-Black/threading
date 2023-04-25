package org.example.account;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.constants.Accounts;

import java.util.List;
import java.util.concurrent.Callable;

public class GetAccountDetails implements Callable<AccountDetails> {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Integer accountId;

    public GetAccountDetails(Integer accountId) {
        super();
        this.accountId = accountId;
    }

    private static AccountDetails getDetails(Integer accountId) {
        List<AccountDetails> accounts = Accounts.getAccounts();

        LOGGER.info("Retrieving Account Details for Account ID: {}", accountId);

        AccountDetails accountDetails = accounts.stream()
                        .filter(el -> accountId == el.getId())
                        .findFirst()
                        .orElse(null);

        LOGGER.info("Account Details retrieved: {}", accountDetails);
        return accountDetails;
    }

    @Override
    public AccountDetails call() {
        return getDetails(accountId);
    }
}
