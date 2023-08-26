package model;

public class Customer extends Person{

    public Customer(String firstName, String lastName, String personalnr,String customerId,Address address) {
        super(firstName, lastName, personalnr);
        this.customerId = customerId;
        this.address = address;
    }
    private String customerId;
    private Address address;
    //list of customer accounts
    private Account[] accounts;

}
