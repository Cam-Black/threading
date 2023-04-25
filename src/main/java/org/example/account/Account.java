package org.example.account;

import org.example.customer.Customer;

import java.util.Objects;

public class Account {
    private int id;
    private Customer customer;
    private String openDate;
    private String prodType;

    public Account() {
        super();
    }

    public Account(int id, Customer customer, String openDate, String prodType) {
        this.id = id;
        this.customer = customer;
        this.openDate = openDate;
        this.prodType = prodType;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getOpenDate() {
        return openDate;
    }

    public String getProdType() {
        return prodType;
    }

    @Override
    public String toString() {
        return "Account{" +
                        "customer=" + customer +
                        ", openDate='" + openDate + '\'' +
                        ", prodType='" + prodType + '\'' +
                        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Account account = (Account) o;
        return Objects.equals(openDate, account.openDate) && Objects.equals(prodType,
                        account.prodType) && Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openDate, prodType, customer);
    }
}
