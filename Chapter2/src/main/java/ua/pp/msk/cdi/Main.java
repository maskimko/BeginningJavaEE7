/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author maskimko
 */
public class Main {
    public static void main (String [] args){
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("Some Book", 95.32f, "Some usual book");
        System.out.println(book);
        weld.shutdown();
    }
}
