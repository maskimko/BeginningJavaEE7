/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.ejb;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maskimko
 */
@Dependent
public class DatabaseProduces {

    public DatabaseProduces() {
    }
    
    
    @Produces
    @PersistenceContext(unitName = "chapter08PU")
    private EntityManager em;
}
