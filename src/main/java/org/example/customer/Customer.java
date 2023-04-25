package org.example.customer;

public class Customer {
    private int id;
    private String forename;
    private String surname;
    private String dob;

    public Customer() {
        super();
    }

    public Customer(int id, String forename, String surname, String dob) {
        super();
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                        "id=" + id +
                        ", forename='" + forename + '\'' +
                        ", surname='" + surname + '\'' +
                        ", dob='" + dob + '\'' +
                        '}';
    }
}
