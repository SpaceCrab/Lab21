package model;

public class CustomerManager {
    private Customer[] customers;
    private int maxCustomers;

    public CustomerManager(int maxCustomers) {
        this.maxCustomers = maxCustomers;
        customers = new Customer[maxCustomers];
    }
    public boolean addNew(Customer currentCustomer) {
        return true;
    }
}
