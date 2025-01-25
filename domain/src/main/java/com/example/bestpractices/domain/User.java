package com.example.bestpractices.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class User {

    private String firstName;
    private String lastName;
    private String email; // Assuming email is the unique identifier
    private String phoneNumber;
    private final List<Address> addresses;

    // Constructor for initialization
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addresses = new ArrayList<>();
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Address> getAddresses() {
        return Collections.unmodifiableList(addresses); // Defensive copy for immutability
    }

    // Mutator Methods for Controlled Updates
    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Business Logic for Address Management
    public void addAddress(Address address) {
        if (address != null) {
            this.addresses.add(address);
        }
    }

    public void updateAddress(int index, Address newAddress) {
        if (index >= 0 && index < addresses.size() && newAddress != null) {
            this.addresses.set(index, newAddress);
        }
    }

    public void removeAddress(Address address) {
        this.addresses.remove(address);
    }

    // Equality and HashCode based on email (unique identifier)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    // toString for Debugging
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
