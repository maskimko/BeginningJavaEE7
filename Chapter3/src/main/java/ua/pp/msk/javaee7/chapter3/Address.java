/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.chapter3;

import javax.validation.constraints.NotNull;

/**
 *
 * @author maskimko
 */
public class Address {
    @NotNull
private String street1;
private String street2;
@NotNull
private String city;
private String state;
@NotNull @ZipCode
private String zipCode;
private String Country;

    public Address() {
    }

    public Address(String street1, String city, String state, String zipCode, String Country) {
        this.street1 = street1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.Country = Country;
    }

    
    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }



}
