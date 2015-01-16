/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.chapter3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author maskimko
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String>{

    @Inject @USA
    private ZipCodeChecker checker;
    private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");
    
    @Override
    public void initialize(ZipCode a) {
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        if (t == null)
            return true;
        
        Matcher m = zipPattern.matcher(t);
        if (!m.matches())
            return false;
        
        return checker.isZipCodeValid(t);
    }
    
}
