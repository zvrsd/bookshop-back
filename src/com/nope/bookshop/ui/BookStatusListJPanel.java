package com.nope.bookshop.ui;

import com.nope.bookshop.dao.BookStatusDAO;
import com.nope.bookshop.uidefault.ListGenericJPanel;
import com.nope.bookshop.entity.BookStatus;
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
public class BookStatusListJPanel extends ListGenericJPanel<BookStatus> implements DatabaseUpdateListener{
    
    private BookStatusDAO bookStatusDAO;

    public BookStatusListJPanel() {
        super();
        bookStatusDAO = new BookStatusDAO();
        initTable();
        setTitle(Strings.TEXT_LIST + Strings.ELEMENT_BOOK_STATUS);
    }

    @Override
    protected void initTable(){
        setTableModel(getDefaultTableModel());
    }

    @Override
    public DefaultTableModel getDefaultTableModel() {

        Vector<String> columnNames = new Vector<>();
        Vector<Vector> data = new Vector<>();

        elements = bookStatusDAO.getAll();
        Vector<BookStatus> bookStatuses = new Vector(elements);

        columnNames.add("ID");
        columnNames.add("Nom");

        for (BookStatus bookStatus : bookStatuses) {

            Vector<Object> row = new Vector<>();
            row.add(bookStatus.getId());
            row.add(bookStatus.getName());
            row.add(bookStatus);
            data.add(row);
        }

        return new UneditableTableModel(data, columnNames);
    }

    @Override
    public void addNewElement() {
        super.addNewElement();
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            BookStatusAddJPanel bookStatusAddJPanel = new BookStatusAddJPanel(dialog);
            
            bookStatusAddJPanel.addDatabaseListener(this);
            bookStatusAddJPanel.setTitle(Strings.TEXT_CREATE + Strings.ELEMENT_BOOK_STATUS);
            
            dialog.setContentPane(bookStatusAddJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
    }

    @Override
    public void editSelectedElement(BookStatus element) {
        super.editSelectedElement(element);
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            BookStatusEditJPanel bookStatusEditJPanel = new BookStatusEditJPanel(dialog, element);
            
            bookStatusEditJPanel.addDatabaseListener(this);
            bookStatusEditJPanel.setTitle(Strings.TEXT_EDIT + Strings.ELEMENT_BOOK_STATUS);
            
            dialog.setContentPane(bookStatusEditJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
    }

    
    @Override
    public void databaseUpdated() {
        initTable();
    }
}