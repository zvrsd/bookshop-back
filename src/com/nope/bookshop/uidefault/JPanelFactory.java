package com.nope.bookshop.uidefault;

import com.nope.bookshop.uidefault.ListGenericJPanel;
import com.nope.bookshop.res.Strings;
import javax.swing.JPanel;

/**
 *
 * @author zvr
 */
public class JPanelFactory {

    public JPanel getJPanel(String panelType){
        
        switch(panelType){
            
            case(Strings.MENU_ADD + Strings.ELEMENT_BOOK) :
                return new ListGenericJPanel();
            
            case(Strings.MENU_SHOW + Strings.ELEMENT_CATEGORY) :
                return new ListGenericJPanel();
                
            default:
                return new ListGenericJPanel(panelType);
        }
    }
}
