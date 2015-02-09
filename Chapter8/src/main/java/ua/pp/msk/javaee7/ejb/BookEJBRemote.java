/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.validation.constraints.NotNull;

/**
 *
 * @author maskimko
 */
@Remote
public interface BookEJBRemote {
    public @NotNull Book createBook(@NotNull Book book);
    public @NotNull Book updateBook(@NotNull Book book);
    public List<Book> findBooks();
    public void deleteBook(@NotNull Book book);
}
