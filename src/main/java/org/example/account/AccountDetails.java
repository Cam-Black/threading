package org.example.account;

import org.example.customer.Customer;

import java.util.Objects;

public class AccountDetails {
    private int id;
    private Customer customer;
    private String openDate;
    private String prodType;

    public AccountDetails() {
        super();
    }

    public AccountDetails(int id, Customer customer, String openDate, String prodType) {
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
        return "AccountDetails{" +
                        "customer=" + getCustomer() +
                        ", openDate='" + getOpenDate() + '\'' +
                        ", prodType='" + getProdType() + '\'' +
                        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AccountDetails accountDetails = (AccountDetails) o;
        return Objects.equals(openDate, accountDetails.openDate) && Objects.equals(prodType,
                        accountDetails.prodType) && Objects.equals(customer, accountDetails.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openDate, prodType, customer);
    }
}
