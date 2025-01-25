package com.example.bestpractices.domain;

import java.util.Objects;

public final class Address {

    private final String streetAddress;
    private final String doorNumber;
    private final String locality;
    private final String city;
    private final String country;
    private final String state;
    private final String zip;

    // Constructor for initialization
    public Address(String streetAddress, String doorNumber, String locality, String city,
                   String country, String state, String zip) {
        this.streetAddress = streetAddress;
        this.doorNumber = doorNumber;
        this.locality = locality;
        this.city = city;
        this.country = country;
        this.state = state;
        this.zip = zip;
    }

    // Getters (No setters, ensuring immutability)
    public String getStreetAddress() {
        return streetAddress;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public String getLocality() {
        return locality;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    // With-methods for creating updated instances
    public Address withStreetAddress(String streetAddress) {
        return new Address(streetAddress, this.doorNumber, this.locality, this.city,
                this.country, this.state, this.zip);
    }

    public Address withDoorNumber(String doorNumber) {
        return new Address(this.streetAddress, doorNumber, this.locality, this.city,
                this.country, this.state, this.zip);
    }

    public Address withLocality(String locality) {
        return new Address(this.streetAddress, this.doorNumber, locality, this.city,
                this.country, this.state, this.zip);
    }

    public Address withCity(String city) {
        return new Address(this.streetAddress, this.doorNumber, this.locality, city,
                this.country, this.state, this.zip);
    }

    public Address withCountry(String country) {
        return new Address(this.streetAddress, this.doorNumber, this.locality, this.city,
                country, this.state, this.zip);
    }

    public Address withState(String state) {
        return new Address(this.streetAddress, this.doorNumber, this.locality, this.city,
                this.country, state, this.zip);
    }

    public Address withZip(String zip) {
        return new Address(this.streetAddress, this.doorNumber, this.locality, this.city,
                this.country, this.state, zip);
    }

    // Equals and HashCode for comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(streetAddress, address.streetAddress) &&
                Objects.equals(doorNumber, address.doorNumber) &&
                Objects.equals(locality, address.locality) &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country) &&
                Objects.equals(state, address.state) &&
                Objects.equals(zip, address.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddress, doorNumber, locality, city, country, state, zip);
    }

    // toString for debugging
    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", doorNumber='" + doorNumber + '\'' +
                ", locality='" + locality + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
