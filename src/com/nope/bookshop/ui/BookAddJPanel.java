package com.nope.bookshop.ui;

import com.nope.bookshop.dao.BookDAO;
import com.nope.bookshop.entity.Book;
import com.nope.bookshop.exception.DatabaseException;
import com.nope.bookshop.res.Strings;
import java.awt.Window;
import javax.swing.JOptionPane;

/**
 *
 * @author zvr
 */
public class BookAddJPanel extends BookEditJPanel{

    public BookAddJPanel(Window parent) {
        super(null, null);
    }

    @Override
    protected void confirmAction() {
        int result = JOptionPane.showConfirmDialog(
                this,
                Strings.MSG_ASK_CONFIRMATION, 
                Strings.MSG_CONFIRM_CREATION, 
                JOptionPane.YES_NO_OPTION
        );
        if(getParentWindow() == null){
            return;
        }
        if(result == JOptionPane.YES_OPTION){
            Book newBook = new Book();
            newBook.setIsbn(getISBN());
            newBook.setTitle(getTitle());
            newBook.setSubTitle(getSubTitle());
            newBook.setCoverURL(getCoverURL());
            newBook.setPostIt(getPostItText());
            newBook.setShelf(getShelf());
            newBook.setQuantity(getStock());
            newBook.setPublisher(getPublisher());
            newBook.setAuthors(getAuthors());
            newBook.setCategories(getCategories());
            newBook.setKeywords(getKeywords());
            newBook.setStatuses(getStatuses());
            newBook.setVat(getVat());
            newBook.setPrice(getPrice());
            
            try {
                
                new BookDAO().add(newBook);
            } catch (DatabaseException ex) {
                JOptionPane.showMessageDialog(
                        this, 
                        ex.getMessage(), 
                        Strings.MSG_ERROR, 
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            
            JOptionPane.showMessageDialog(
                        this, 
                        Strings.ELEMENT_BOOK+" "+Strings.MSG_SUCCESSFULLY_ADDED, 
                        Strings.MSG_INFO, 
                        JOptionPane.INFORMATION_MESSAGE
            );
            
            notifyDatabaseListener();
            getParentWindow().dispose();
        }
    }

    @Override
    protected void cancelAction() {
        int result = JOptionPane.showConfirmDialog(
                this,
                Strings.MSG_ASK_CONFIRMATION,
                Strings.MSG_CANCEL_CREATION,
                JOptionPane.YES_NO_OPTION
        );
        if (getParentWindow() == null) {
            return;
        }
        if (result == JOptionPane.YES_OPTION) {
            getParentWindow().dispose();

        }
    }
    
    

}
