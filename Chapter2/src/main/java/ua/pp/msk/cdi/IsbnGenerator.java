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
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;
    
    @Override
    @Loggable
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.info("Generated ISBN : " + isbn);
        return isbn;
    }
    
}
