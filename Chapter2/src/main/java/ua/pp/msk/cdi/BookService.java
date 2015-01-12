/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.cdi;

import javax.inject.Inject;

/**
 *
 * @author maskimko
 */
@Loggable
public class BookService {
    
    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator;
            
    public Book createBook(String title, float price, String description){
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}
