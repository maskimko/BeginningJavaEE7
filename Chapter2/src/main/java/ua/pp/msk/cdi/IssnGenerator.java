/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.cdi;

import java.util.Random;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author maskimko
 */
@EightDigits
public class IssnGenerator implements NumberGenerator{
    
    @Inject
    private Logger logger;
    
    @Loggable
    public String generateNumber(){
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Generated ISSN : " + issn);
        return issn;
    }
}
