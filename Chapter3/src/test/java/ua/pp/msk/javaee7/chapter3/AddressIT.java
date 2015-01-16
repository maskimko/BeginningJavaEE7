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
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;

/**
 *
 * @author maskimko
 */
public class AddressIT {
    
    private static ValidatorFactory vf;
    private static Validator validator;
    
    @BeforeClass
    public static void init(){
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }
    
    @AfterClass
    public static void shutdown(){
        vf.close();
    }
    
    public void shouldRaiseConstraintViolationCauseInvalidZipCode() {
        Address a = new Address("3a, Hryshka str.", "Kyiv", "Kyivska obl.", "DummyZip", "Ukraine");
        Set<ConstraintViolation<Address>> violations = validator.validate(a);
        assertEquals(1, violations.size());
    }
}
