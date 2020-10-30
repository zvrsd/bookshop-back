package com.nope.bookshop.ui;

import com.nope.bookshop.dao.BookDAO;
import com.nope.bookshop.entity.Book;
import com.nope.bookshop.exception.DatabaseException;
import com.nope.bookshop.uidefault.ListGenericJPanel;
import com.nope.bookshop.listener.DatabaseUpdateListener;
import com.nope.bookshop.res.Strings;
import com.nope.bookshop.uidefault.GenericJDialog;
import com.nope.bookshop.uimodel.UneditableTableModel;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zvr
 */
public class BookListJPanel extends ListGenericJPanel<Book> implements DatabaseUpdateListener{
    
    private BookDAO bookDAO;

    public BookListJPanel() {
        super();
        bookDAO = new BookDAO();
        initTable();
        setTitle(Strings.TEXT_LIST + Strings.ELEMENT_BOOK);
    }

    @Override
    protected void initTable(){
        setTableModel(getDefaultTableModel());
    }

    @Override
    public DefaultTableModel getDefaultTableModel() {

        Vector<String> columnNames = new Vector<>();
        Vector<Vector> data = new Vector<>();

        try {
            elements = bookDAO.getAll();
        } catch (DatabaseException ex) {
            JOptionPane.showMessageDialog(
                    this, 
                    Strings.MSG_CANNOT_LOAD_DATA, 
                    Strings.MSG_ERROR, 
                    JOptionPane.ERROR_MESSAGE);
        }
        Vector<Book> books = new Vector(elements);

        columnNames.add("ISBN");
        columnNames.add("Titre");
        columnNames.add("Sous-titre");
        columnNames.add("Prix");

        for (Book book : books) {

            Vector<Object> row = new Vector<>();
            row.add(book.getIsbn());
            row.add(book.getTitle());
            row.add(book.getSubTitle());
            row.add(book.getPrice());
            row.add(book);
            data.add(row);
        }

        return new UneditableTableModel(data, columnNames);
    }

    @Override
    public void addNewElement() {
        super.addNewElement();
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            BookAddJPanel bookAddJPanel = new BookAddJPanel(dialog);
            
            bookAddJPanel.addDatabaseListener(this);
            bookAddJPanel.setTitle(Strings.TEXT_CREATE + Strings.ELEMENT_BOOK);
            
            dialog.setContentPane(bookAddJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
    }

    @Override
    public void editSelectedElement(Book element) {
        super.editSelectedElement(element);
            GenericJDialog dialog = new GenericJDialog(SwingUtilities.getWindowAncestor(this));
            BookEditJPanel bookEditJPanel = new BookEditJPanel(dialog, element);
            
            bookEditJPanel.addDatabaseListener(this);
            bookEditJPanel.setTitle(Strings.TEXT_EDIT + Strings.ELEMENT_BOOK);
            
            dialog.setContentPane(bookEditJPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
    }

    @Override
    public void databaseUpdated() {
        initTable();
    }
}