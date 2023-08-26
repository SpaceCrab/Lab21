package model;

public class Customer extends Person{
    private String customerId;
    private Address address;
    private String phoneNumber;

    public Customer(String customerId, String firstName, String lastName, String personalnr, Address address) {
        super(firstName, lastName, personalnr);
        this.customerId = customerId;
        this.address = address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAddressString() {
        return address.toString();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        if (customerId != null && !customerId.isEmpty()) {
            this.customerId = customerId;
        }
    }

    public String[] getInfoStrings()
    {
        String[] infoStrings = new String[5];
        infoStrings[0] = "First name: " + getFirstName();
        infoStrings[1] = "Last name: " + getLastName();
        infoStrings[2] = "Personal Nr: " + getPersonalNr();
        infoStrings[3] = "Customer Id: " + customerId;
        infoStrings[4] = "Address: " + address.toString();
        return infoStrings;
    }

}
