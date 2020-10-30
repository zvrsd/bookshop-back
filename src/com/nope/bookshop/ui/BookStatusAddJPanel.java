package com.nope.bookshop.ui;

import com.nope.bookshop.dao.BookStatusDAO;
import com.nope.bookshop.entity.BookStatus;
import com.nope.bookshop.exception.DatabaseException;
import java.awt.Window;
import javax.swing.JOptionPane;
import com.nope.bookshop.res.Strings;

/**
 *
 * @author cda601
 */
public class BookStatusAddJPanel extends BookStatusEditJPanel{
    
    public BookStatusAddJPanel(Window parent) {
        super(parent, null);
        allowDeletion(false);
    }
    
    @Override
    protected void cancelAction(){
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
    
    @Override
    protected void confirmAction(){
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
            BookStatus bookStatus = new BookStatus();
            bookStatus.setName(getNameText());
            bookStatus.setPostIt(getPostItText());
            
            try {
                new BookStatusDAO().add(bookStatus);
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
                        Strings.ELEMENT_BOOK_STATUS+" "+Strings.MSG_SUCCESSFULLY_ADDED, 
                        Strings.MSG_INFO, 
                        JOptionPane.INFORMATION_MESSAGE
            );
            
            notifyDatabaseListener();
            getParentWindow().dispose();
        }
    }
}