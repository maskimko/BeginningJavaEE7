/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author maskimko
 */
@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/chapter08DS",
        user = "app",
        password = "app",
        databaseName = "chapter08DB",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    private BookEJB bookEJB;
    
    private Book h2g2;
    private Book lord;
    
    @PostConstruct
    private void populateDB() {
        h2g2 = new Book("Beginning Java EE 7", 35F, "Great book", "1-8763-9125-7", 605, true);
        lord = new Book("The Lord of the Rings", 50.4f, "SciFi", "1-84023-742-2", 1216, true);
        
        bookEJB.createBook(h2g2);
        bookEJB.createBook(lord);
    }
    
    private void clearDB() {
        bookEJB.deleteBook(lord);
        bookEJB.deleteBook(h2g2);
    }
}
