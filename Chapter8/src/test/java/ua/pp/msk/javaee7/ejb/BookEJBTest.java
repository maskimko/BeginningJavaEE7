/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.ejb;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maskimko
 */
public class BookEJBTest {

    public BookEJBTest() {
    }


    /**
     * Test of createBook method, of class BookEJB.
     */
    @Test
    public void shouldCreateBook() throws Exception {
        System.out.println("integration test, Create a Book");
        Map<String, Object> properties = new HashMap();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
            Context ctx = ec.getContext();
            System.out.println("Looking up java jdbc jndi resources");
            NamingEnumeration<NameClassPair> jdbcList = ctx.list("java:global/jdbc");
            while(jdbcList.hasMore()){
                System.out.println("\t"+jdbcList.next().getName());
            }
            assertNotNull(ctx.lookup("java:global/jdbc/chapter08DS"));
            assertNotNull(ctx.lookup("java:global/classes/BookEJB!ua.pp.msk.javaee7.ejb.BookEJBRemote"));
            assertNotNull(ctx.lookup("java:global/classes/BookEJB!ua.pp.msk.javaee7.ejb.BookEJB"));
            Book book = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
            BookEJBRemote bookEJB = (BookEJBRemote) ctx.lookup("java:global/classes/BookEJB!ua.pp.msk.javaee7.ejb.BookEJBRemote");
            assertEquals(2, bookEJB.findBooks().size());
            book = new Book("H2G2", 12.5f, "Scifi book", "1-24561-799-0", 354, false);
            book = bookEJB.createBook(book);
            assertNotNull("ID should not be null", book.getId());
            assertEquals(3, bookEJB.findBooks().size());
            bookEJB.deleteBook(book);
            assertEquals(2, bookEJB.findBooks().size());
//        container.close();

        }

    }

//    /**
//     * Test of updateBook method, of class BookEJB.
//     */
//    @Test
//    public void testUpdateBook() throws Exception {
//        System.out.println("updateBook");
//        Book book = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        BookEJBRemote instance = (BookEJBRemote)container.getContext().lookup("java:global/classes/BookEJB");
//        Book expResult = null;
//        Book result = instance.updateBook(book);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findBooks method, of class BookEJB.
//     */
//    @Test
//    public void testFindBooks() throws Exception {
//        System.out.println("findBooks");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        BookEJBRemote instance = (BookEJBRemote)container.getContext().lookup("java:global/classes/BookEJB");
//        List<Book> expResult = null;
//        List<Book> result = instance.findBooks();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteBook method, of class BookEJB.
//     */
//    @Test
//    public void testDeleteBook() throws Exception {
//        System.out.println("deleteBook");
//        Book book = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        BookEJBRemote instance = (BookEJBRemote)container.getContext().lookup("java:global/classes/BookEJB");
//        instance.deleteBook(book);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
