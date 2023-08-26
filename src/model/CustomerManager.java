package model;

public class CustomerManager {
    private Customer[] customers;
    public CustomerManager() {
        customers = new Customer[3];
        Address address = new Address("Gatan 1", "12345", "Staden");
        customers[0] = new Customer("Kalle", "Anka", "1234567890", "123", address);
        address = new Address("Gatan 2", "12345", "Staden");
        customers[1] = new Customer("Nisse", "Hult", "1234567890", "124", address);
        address = new Address("Gatan 3", "12345", "Staden");
        customers[2] = new Customer("Lisa", "Simpson", "1234567890", "125", address);
    }

    public String[] getCustomerList()
    {
        String[] customerList = new String[customers.length];
        for(int i = 0; i < customers.length; i++)
        {
            customerList[i] = customers[i].toString();
        }
        return customerList;
    }
}
