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
}
