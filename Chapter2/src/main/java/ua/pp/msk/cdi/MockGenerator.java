/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.cdi;

import java.util.Random;
import java.util.logging.Logger;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

/**
 *
 * @author maskimko
 */
@ThirteenDigits
@Alternative
public class MockGenerator {
    
    @Inject
    private Logger logger;
    
    public String generateNumber(){
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        logger.info("Generated MOCK : " + mock);
        return mock;
    }
}
