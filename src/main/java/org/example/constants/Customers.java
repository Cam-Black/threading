package org.example.constants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.customer.Customer;

import java.util.Arrays;
import java.util.List;

public class Customers {
    private static final Logger LOGGER = LogManager.getLogger();

    private Customers() {
        super();
    }
    public static final Customer customerOne = new Customer(1, "John", "Doe", "2000-06-15");
    public static final Customer customerTwo = new Customer(2, "Jane", "Doe", "1990-12-10");
    public static final Customer customerThree = new Customer(3, "Joe", "Bloggs", "1995-04-06");
    public static final Customer customerFour = new Customer(4, "Billy", "Boy", "2002-06-11");
    public static final Customer customerFive = new Customer(5, "Boy", "George", "1998-03-18");

    public static Customer getCustomerFromId(int id) {
        List<Customer> customerList = Arrays.asList(customerOne, customerTwo, customerThree, customerFour, customerFive);
        try {
            Customer customer = customerList.get(id-1);
            LOGGER.info("Customer found: {}", customer);
            return customer;
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error("No Customer Found for ID: {}", id);
            return new Customer();
        }

    }
}
