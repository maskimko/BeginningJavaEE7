/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.jsf;

import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author maskimko
 */
@Named
@Dependent
@Stateless
@DataSourceDefinition(name = "java:global/jdbc/lb11DS",
        className = "org.apache.derby.jdbc.EmbeddedDriver",
        url = "jdbc:derby:memory:lab11DB;create=true;user=app;password=app")
public class BookEJB implements BookEJBLocal {

    public BookEJB() {
    }

    
    
    @Inject
    private EntityManager em;
    
    @Override
    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public List<Book> findAllBooks(){
        return em.createNamedQuery("findAllBooks", Book.class).getResultList();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public Book findBookById(Long id){
        return em.find(Book.class, id);
    }
}
