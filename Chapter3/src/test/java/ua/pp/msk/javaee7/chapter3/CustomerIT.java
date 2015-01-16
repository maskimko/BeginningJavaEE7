/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.chapter3;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maskimko
 */
public class CustomerIT {
    
    private static ValidatorFactory vf;
    private static Validator validator;
    
    public CustomerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }
    
    @AfterClass
    public static void tearDownClass() {
        vf.close();
    }
    
   

    @Test
    public void shouldRaiseNoConstraintViolation(){
        Customer customer = new Customer("John", "Smith", "jsmith@gmail.com");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(0, violations.size());
    }
    
    @Test
    public void shouldRaiseConstraintViolationCauseInvalidEmail(){
        Customer customer = new Customer("John", "Smith", "DummyEmail");
        //Customer customer = new Customer("John", "Smith", "jsmith@gmail.com");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertEquals(1, violations.size());
        assertEquals("invalid email address", violations.iterator().next().getMessage());
        assertEquals("DummyEmail", violations.iterator().next().getInvalidValue());
        assertEquals("{ua.pp.msk.javaee7.chapter3.Email.message}", violations.iterator().next().getMessageTemplate());
        
    }
    
}
