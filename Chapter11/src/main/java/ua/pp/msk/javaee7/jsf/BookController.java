/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.pp.msk.javaee7.jsf;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Named
@RequestScoped
public class BookController {

    @Inject
    private BookEJBLocal bookEJB;
    private Book book = new Book();
    
    public String doCreateBook() {
        bookEJB.createBook(book);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Book created", 
                        "The book "+ book.getTitle() + " has been created with id="+book.getId()));
        return "newBook.xhtml";
    }
    
    public void doFindBookById() {
        book = bookEJB.findBookById(book.getId());
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    
}
