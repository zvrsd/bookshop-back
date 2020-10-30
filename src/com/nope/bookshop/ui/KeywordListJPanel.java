package com.nope.bookshop.ui;

import com.nope.bookshop.uidefault.ListGenericJPanel;
import com.nope.bookshop.dao.KeywordDAO;
import com.nope.bookshop.entity.Keyword;
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
public class KeywordListJPanel extends ListGenericJPanel<Keyword> implements DatabaseUpdateListener{
    
    private KeywordDAO keywordDAO;

    public KeywordListJPanel() {
        super();
        keywordDAO = new KeywordDAO();
        initTable();
        setTitle(Strings.TEXT_LIST + Strings.ELEMENT_KEYWORD);
    }

    @Override
    protected void initTable(){
        setTableModel(getDefaultTableModel());
    }

    @Override
    public DefaultTableModel getDefaultTableModel() {

        Vector<String> columnNames = new Vector<>();
        Vector<Vector> data = new Vector<>();

        elements = keywordDAO.getAll();
        Vector<Keyword> keywords = new Vector(elements);

        columnNames.add("ID");
        columnNames.add("Nom");

        for (Keyword keyword : keywords) {

            Vector<Object> row = new Vector<>();
            row.add(keyword.getId());
            row.add(keyword.getName());
            row.add(keyword);
            data.add(row);
        }

        return new UneditableTableModel(data, columnNames);
    }

    @Override
    public void addNewElement() {
        super.addNewElement();
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            KeywordAddJPanel keywordAddJPanel = new KeywordAddJPanel(dialog);
            
            keywordAddJPanel.addDatabaseListener(this);
            keywordAddJPanel.setTitle(Strings.TEXT_CREATE + Strings.ELEMENT_KEYWORD);
            
            dialog.setContentPane(keywordAddJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
    }

    @Override
    public void editSelectedElement(Keyword element) {
        super.editSelectedElement(element);
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            KeywordEditJPanel keywordEditJPanel = new KeywordEditJPanel(dialog, element);
            
            keywordEditJPanel.addDatabaseListener(this);
            keywordEditJPanel.setTitle(Strings.TEXT_EDIT + Strings.ELEMENT_KEYWORD);
            
            dialog.setContentPane(keywordEditJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
    }

    
    @Override
    public void databaseUpdated() {
        initTable();
    }
}