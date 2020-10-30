package com.nope.bookshop.ui;

import com.nope.bookshop.dao.VatDAO;
import com.nope.bookshop.entity.Vat;
import com.nope.bookshop.exception.DatabaseException;
import com.nope.bookshop.res.Strings;
import java.awt.Window;
import javax.swing.JOptionPane;

/**
 *
 * @author zvr
 */
public class VatAddJPanel extends VatEditJPanel{

    public VatAddJPanel(Window parent) {
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
            Vat vat = new Vat();
            try {
                vat.setRate(Float.parseFloat(getVatRateValue()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        this, 
                        Strings.MSG_INVALID_FIELD+" : "+e.getMessage(), 
                        Strings.MSG_ERROR, 
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            
            try {
                new VatDAO().add(vat);
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
                        Strings.ELEMENT_VAT+" "+Strings.MSG_SUCCESSFULLY_ADDED, 
                        Strings.MSG_INFO, 
                        JOptionPane.INFORMATION_MESSAGE
            );
            
            notifyDatabaseListener();
            getParentWindow().dispose();
        }
    }
}
