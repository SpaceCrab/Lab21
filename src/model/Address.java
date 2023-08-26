package model;

public class Address {
    private String street;
    private String city;
    private String zipCode;

    public Address() {

    }

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.street = city;
    }

    public void setZipCode(String zipCode) {
        this.street = zipCode;
    }

    public String toString() {
        return street + " " + zipCode + " " + city;
    }
}
