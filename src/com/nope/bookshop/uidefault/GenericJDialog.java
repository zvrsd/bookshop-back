package com.nope.bookshop.uidefault;

import java.awt.Dialog;
import java.awt.Window;
import javax.swing.JDialog;

/**
 *
 * @author zvr
 */
public class GenericJDialog extends JDialog{
    
    public GenericJDialog(Window parent){
        super(parent);
        init();
    }
    
    private void init(){
        setLocationRelativeTo(getOwner());
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setModal(true);
    }
}
