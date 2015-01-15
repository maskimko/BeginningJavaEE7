/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.chapter3;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author maskimko
 */
public class Customer {
    @NotNull @Size(min = 2)
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phoneNumber;
    @Past
    private Date dateOfBirth;
    private Address deliveryAddress;
}
