/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.javaee7.ejb;

import java.io.Serializable;

/**
 *
 * @author martin
 */

public class Book implements Serializable {

    public final static String FIND_ALL = "FINDALL";
    
  
   private long id;
  
   private String title;
   private float price;
   
   private String desctiption;
   private String isbn;
   private int numOfPages;
   private boolean illustrations;

    public Book() {
    }

    public Book(String title, float price, String desctiption, String isbn, int numOfPages, boolean illustrations) {
        this.title = title;
        this.price = price;
        this.desctiption = desctiption;
        this.isbn = isbn;
        this.numOfPages = numOfPages;
        this.illustrations = illustrations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public boolean isIllustrations() {
        return illustrations;
    }

    public void setIllustrations(boolean illustrations) {
        this.illustrations = illustrations;
    }
  
    
}
