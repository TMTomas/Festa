package pt.brunojesus.contactslib.model;

/**
 * POJO representing a Contact
 */
public class ContactAPI {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String company;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public ContactAPI setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactAPI setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactAPI setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactAPI setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public ContactAPI setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ContactAPI setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
