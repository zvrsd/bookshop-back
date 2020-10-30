package com.nope.bookshop.ui;

import com.nope.bookshop.dao.PublisherDAO;
import com.nope.bookshop.uidefault.ListGenericJPanel;
import com.nope.bookshop.entity.Publisher;
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
public class PublisherListJPanel extends ListGenericJPanel<Publisher> implements DatabaseUpdateListener{
    
    private PublisherDAO publisherDAO;

    public PublisherListJPanel() {
        super();
        publisherDAO = new PublisherDAO();
        initTable();
        setTitle(Strings.TEXT_LIST + Strings.ELEMENT_PUBLISHER);
    }

    @Override
    protected void initTable(){
        setTableModel(getDefaultTableModel());
    }

    @Override
    public DefaultTableModel getDefaultTableModel() {

        Vector<String> columnNames = new Vector<>();
        Vector<Vector> data = new Vector<>();

        elements = publisherDAO.getAll();
        Vector<Publisher> publishers = new Vector(elements);

        columnNames.add("ID");
        columnNames.add("Nom");
        columnNames.add("Adresse");
        columnNames.add("Post-it");

        for (Publisher publisher : publishers) {

            Vector<Object> row = new Vector<>();
            row.add(publisher.getId());
            row.add(publisher.getName());
            row.add(publisher.getAddress());
            row.add(publisher.getPostIt());
            row.add(publisher);
            data.add(row);
        }

        return new UneditableTableModel(data, columnNames);
    }

    @Override
    public void addNewElement() {
        super.addNewElement();
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            PublisherAddJPanel publisherAddJPanel = new PublisherAddJPanel(dialog);
            
            publisherAddJPanel.addDatabaseListener(this);
            publisherAddJPanel.setTitle(Strings.TEXT_CREATE + Strings.ELEMENT_PUBLISHER);
            
            dialog.setContentPane(publisherAddJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
    }

    @Override
    public void editSelectedElement(Publisher element) {
        super.editSelectedElement(element);
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            PublisherEditJPanel publisherEditJPanel = new PublisherEditJPanel(dialog, element);
            
            publisherEditJPanel.addDatabaseListener(this);
            publisherEditJPanel.setTitle(Strings.TEXT_EDIT + Strings.ELEMENT_PUBLISHER);
            
            dialog.setContentPane(publisherEditJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
    }

    
    @Override
    public void databaseUpdated() {
        initTable();
    }
}