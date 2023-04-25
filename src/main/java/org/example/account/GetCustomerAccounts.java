package org.example.account;

import org.example.constants.AccountDetails;
import org.example.constants.CustomerDetails;
import org.example.customer.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class GetCustomerAccounts {
    private GetCustomerAccounts() {
        super();
    }

    public static List<Integer> getAccountIdsFromCustomerId(int id) {
        List<Account> accounts = AccountDetails.getAccounts();
        Customer customer = CustomerDetails.getCustomerFromId(id);
        return accounts.stream()
                        .filter(el -> el.getCustomer().getId() == customer.getId())
                        .map(Account::getId)
                        .collect(Collectors.toList());
    }
}
