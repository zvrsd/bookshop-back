package com.nope.bookshop.ui;

import com.nope.bookshop.uidefault.ListGenericJPanel;
import com.nope.bookshop.dao.VatDAO;
import com.nope.bookshop.entity.Vat;
import com.nope.bookshop.listener.DatabaseUpdateListener;
import com.nope.bookshop.res.Strings;
import com.nope.bookshop.uidefault.GenericJDialog;
import com.nope.bookshop.uimodel.UneditableTableModel;
import java.util.Vector;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zvr
 */
public class VatListJPanel extends ListGenericJPanel<Vat> implements DatabaseUpdateListener{
    
    private VatDAO vatDAO;

    public VatListJPanel() {
        super();
        vatDAO = new VatDAO();
        initTable();
        setTitle(Strings.TEXT_LIST + Strings.ELEMENT_VAT);
    }

    @Override
    protected void initTable(){
        setTableModel(getDefaultTableModel());
    }

    @Override
    public DefaultTableModel getDefaultTableModel() {

        Vector<String> columnNames = new Vector<>();
        Vector<Vector> data = new Vector<>();

        elements = vatDAO.getAll();
        Vector<Vat> vats = new Vector(elements);

        columnNames.add("ID");
        columnNames.add("Rate");

        for (Vat vat : vats) {

            Vector<Object> row = new Vector<>();
            row.add(vat.getId());
            row.add(vat.getRate());
            row.add(vat);
            data.add(row);
        }

        return new UneditableTableModel(data, columnNames);
    }

    @Override
    public void addNewElement() {
        super.addNewElement();
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            VatAddJPanel vatAddJPanel = new VatAddJPanel(dialog);
            
            vatAddJPanel.addDatabaseListener(this);
            vatAddJPanel.setTitle(Strings.TEXT_CREATE + Strings.ELEMENT_VAT);
            
            dialog.setContentPane(vatAddJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
    }

    @Override
    public void editSelectedElement(Vat element) {
        super.editSelectedElement(element);
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            VatEditJPanel vatEditJPanel = new VatEditJPanel(dialog, element);
            
            vatEditJPanel.addDatabaseListener(this);
            vatEditJPanel.setTitle(Strings.TEXT_EDIT + Strings.ELEMENT_VAT);
            
            dialog.setContentPane(vatEditJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
    }

    @Override
    public void databaseUpdated() {
        initTable();
    }
}