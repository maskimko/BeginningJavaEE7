/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.ejbclient;

import ua.pp.msk.javaee7.ejb.Book;
import ua.pp.msk.javaee7.ejb.BookEJBRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author maskimko
 */
public class Main {

    public static void main(String[] args) throws NamingException {

        Context ctx = new InitialContext();
        System.out.println("Initial factory: " + ctx.getEnvironment().get(Context.INITIAL_CONTEXT_FACTORY));
        BookEJBRemote bookEjb = (BookEJBRemote) ctx.lookup("java:global/EJB/BookEJB!ua.pp.msk.javaee7.ejb.BookEJBRemote");
        if (bookEjb == null) {
            System.err.println("bookEjb is null");
            System.exit(1);
        }
        List<Book> books = bookEjb.findBooks();
        for (Book aBook : books) {
            System.out.println(aBook.getTitle() + " " + aBook.getId());
        }
        
        Book someBook = new Book("Harry Potter", 0.1f, "Fairy tails", "1-0054-2300-1", 550, true);
        someBook = bookEjb.createBook(someBook);
        System.out.println(someBook.getTitle());
        Book book = new Book("H2G2", 12.5f, "Scifi book", "1-24561-799-0", 354, false);
        book = bookEjb.createBook(book);
        System.out.println("Book created: " + book.getTitle());
        book.setTitle("H two G two");
        book = bookEjb.updateBook(book);
        System.out.println("Book updated: " + book.getTitle());
        bookEjb.deleteBook(book);
        System.out.println("Book deleted");
    }
}
