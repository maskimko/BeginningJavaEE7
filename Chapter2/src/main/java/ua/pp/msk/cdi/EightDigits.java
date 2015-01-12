/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.cdi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author maskimko
 */
@Qualifier
@Retention(RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE, ElementType.PARAMETER})
public @interface EightDigits {
    
}
