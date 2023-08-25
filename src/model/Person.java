package model;

public class Person {
    private String firstName;
    private String lastName;
    private String personalnr;

    public Person(){

    }

    public Person(String firstName, String lastName, String personalnr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalnr = personalnr;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPersonalNr(String personalnr) {
        this.personalnr = personalnr;
    }
}
