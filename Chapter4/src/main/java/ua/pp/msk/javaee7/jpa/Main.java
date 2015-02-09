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

/**
 *
 * @author maskimko
 */
public class Main {
    public static void main(String[] args) {
        Book book = new Book("H2G2", 12.5F, "The Hitchhiker's Guide to the Galaxy", "1-84023-742-2", 354, false);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        em.close();
        emf.close();
    }
}
