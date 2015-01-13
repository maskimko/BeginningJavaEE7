/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maskimko
 */
public class BookServiceIT {

    public BookServiceIT() {
    }

    @Test
    public void shouldCheckNumberIsMock() {
        System.out.println("Test shouldCheckNumberIsMock");
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("test book", 0.01f, "Book desined for integration test");
        System.out.println("Created book: " + book);
        assertTrue(book.getNumber().startsWith("MOCK"));
        weld.shutdown();
    }

}
