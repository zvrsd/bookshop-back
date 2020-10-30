
package com.nope.bookshop.ui;

import com.nope.bookshop.dao.CategoryDAO;
import com.nope.bookshop.dao.PublisherDAO;
import com.nope.bookshop.entity.Category;
import com.nope.bookshop.entity.Publisher;
import com.nope.bookshop.exception.DatabaseException;
import com.nope.bookshop.res.Strings;
import com.nope.bookshop.uidefault.GenericJDialog;
import com.nope.bookshop.uidefault.SelectableListJPanel;
import java.awt.Window;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author cda601
 */
public class PublisherAddJPanel extends PublisherEditJPanel{

    public PublisherAddJPanel(Window parent){
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
            Publisher publisher = new Publisher();
            publisher.setName(getNameText());
            publisher.setAddress(getAddress());
            publisher.setPostIt(getPostItText());
            
            try {
                new PublisherDAO().add(publisher);
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
                        Strings.ELEMENT_PUBLISHER+" "+Strings.MSG_SUCCESSFULLY_ADDED, 
                        Strings.MSG_INFO, 
                        JOptionPane.INFORMATION_MESSAGE
            );
            
            notifyDatabaseListener();
            getParentWindow().dispose();
        }
    }
    
    @Override
    protected void editAction(){
        
        /*
        GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
        List<Category> categories = new CategoryDAO().getAll();
        SelectableListJPanel<Category> selectablePanel = new SelectableListJPanel<>(dialog, categories, getCategory().getCategories());
        
        selectablePanel.addListener(this);
        
        dialog.setContentPane(selectablePanel);
        dialog.pack();
        dialog.setLocationRelativeTo(getParentWindow());
        dialog.setVisible(true);
        */
    }
}
