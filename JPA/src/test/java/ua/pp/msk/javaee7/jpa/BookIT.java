/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maskimko
 */
public class BookIT {
   
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
    private EntityManager em;
    private EntityTransaction tx;
    
    
    public BookIT() {
    }
    
   
    @Before
    public void setUp() {
        em = emf.createEntityManager();
        tx= em.getTransaction();
    }
    
    @After
    public void tearDown() {
        if (em != null) em.close();
    }

    @Test
    public void shouldFindJavaEE7Book() throws Exception {
       Book book = em.find(Book.class, 1001L);
       assertEquals("Beginning Java EE 7", book.getTitle());
    }
    
    @Test
    public void shouldCreateH2G2Book() throws Exception {
        Book book = new Book("H2G2", 12.5F, "The Hitchhiker's guide to the Galaxy", "1-84023-742-2", 354, false);
        tx.begin();
        em.persist(book);
        tx.commit();
        assertNotNull("ID shoul not be null", book.getId());
        
        book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
        assertEquals("The Hitchhiker's guide to the Galaxy", book.getDescription());
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void shouldRaiseConstraintViolationCauseNullTitle(){
        Book book = new Book(null, 12.5F, "Null title, should fail", "1-84023-742-2", 354, false);
        em.persist(book);
    }
    
}
