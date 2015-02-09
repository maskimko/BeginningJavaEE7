/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import static ua.pp.msk.javaee7.ejb.Book.FIND_ALL;
/**
 *
 * @author maskimko
 */
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

    @Inject
    private EntityManager em;
    
//    @PersistenceContext(unitName = "chapter08PU")
//    private EntityManager em;
    @Override
    public @NotNull Book createBook(@NotNull Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public @NotNull Book updateBook(@NotNull Book book) {
            return em.merge(book);
    }

    @Override
    public List<Book> findBooks() {
        TypedQuery<Book> query = em.createNamedQuery(FIND_ALL, Book.class);
        return query.getResultList();
        }

    @Override
    public void deleteBook(@NotNull Book book) {
        em.remove(em.merge(book));
    }
    
}
