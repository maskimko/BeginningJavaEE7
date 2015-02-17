/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.jsf;

import java.util.List;
import javax.ejb.Local;
import javax.enterprise.context.Dependent;

/**
 *
 * @author maskimko
 */
@Local
@Dependent
public interface BookEJBLocal {

    Book createBook(Book book);
    List<Book> findAllBooks();
    Book findBookById(Long id);
}
