package model;

public class CustomerManager {
    private Customer[] customers;
    private int customerCount;
    private int maxCustomers;

    private int loginAsCustomerIndex = -1;

    public CustomerManager(int maxCustomers) {
        customerCount = 0;
        this.maxCustomers = maxCustomers;
        customers = new Customer[maxCustomers];
    }

    public int getLoginAsCustomerIndex() {
        return loginAsCustomerIndex;
    }

    public boolean setLoginAsCustomerIndex(int loginAsCustomerIndex) {
        if (loginAsCustomerIndex < 0 || loginAsCustomerIndex >= customerCount) return false;
        this.loginAsCustomerIndex = loginAsCustomerIndex;
        return true;
    }

    public void logout() {
        loginAsCustomerIndex = -1;
    }

    public Customer getLoginAsCustomer() {
        if (loginAsCustomerIndex == -1) return null;
        return customers[loginAsCustomerIndex];
    }

    public String[] getCustomerList()
    {
        String[] customerList = new String[customerCount];
        for(int i = 0; i < customerCount; i++)
        {
            customerList[i] = customers[i].toString();
        }
        return customerList;
    }

    public Customer getCustomer(int index)
    {
        return customers[index];
    }

    public boolean addCustomer(Customer newCustomer)
    {
        if (customerCount >= maxCustomers) return false;
        customers[customerCount++] = newCustomer;
        return true;
    }

    public String getNextID() {
        return String.valueOf(customerCount + 1);
    }

    public String getCurrentID() {
        return String.valueOf(customerCount);
    }
}
