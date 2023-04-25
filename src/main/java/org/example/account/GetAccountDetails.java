package org.example.account;

import org.example.constants.Accounts;

import java.util.List;
import java.util.stream.Collectors;

public class GetAccountDetails {
    private GetAccountDetails() {
        super();
    }

    public static List<Account> getDetails(List<Integer> accountIds) {
        List<Account> accounts = Accounts.getAccounts();
        return accounts.stream()
                        .filter(el -> accountIds
                                        .stream()
                                        .anyMatch(el2 -> el2 == el.getId()))
                        .collect(Collectors.toList());
    }
}
