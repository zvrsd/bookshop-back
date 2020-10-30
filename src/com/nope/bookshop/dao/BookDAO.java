package com.nope.bookshop.dao;

import com.nope.bookshop.entity.Author;
import com.nope.bookshop.entity.Book;
import com.nope.bookshop.entity.Category;
import com.nope.bookshop.entity.Keyword;
import com.nope.bookshop.exception.DatabaseException;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author zvr
 */
public class BookDAO implements DAO<Book>{

    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;
    final ImageIcon icon = new ImageIcon("icone.png");
    Image image2 = icon.getImage().getScaledInstance(32,32,0);

    public final String TABLE_BOOK = "BOOK";
    public final String TABLE_ASSOC_BOOK_STATUS = "ASSOC_STATUS_BOOK";
    public final String TABLE_ASSOC_BOOK_KEYWORD = "ASSOC_BOOK_KEYWORD";
    public final String TABLE_ASSOC_BOOK_AUTHOR = "ASSOC_BOOK_AUTHOR";
    public final String TABLE_ASSOC_BOOK_CATEGORY = "ASSOC_BOOK_CATEGORY";

    public final String QUERY_INSERT_BOOK_STATUS
        = "INSERT INTO " + TABLE_BOOK
        + "(BOOK_ISBN, PUBLISHER_ID, "
        + "VAT_ID, BOOK_TITLE, "
        + "BOOK_SUBTITLE, "
        + "BOOK_HT_PRICE, "
        + "BOOK_COVER_URL, "
        + "BOOK_SUMMARY, "
        + "BOOK_STOCK_QTY,"
        + "BOOK_SHELF, "
        + "BOOK_POST_IT)"
        + " values"
        + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, )";
    
    public final String QUERY_SELECT_ALL_BOOK = 
            "SELECT * FROM "+TABLE_BOOK;
    
    public final String QUERY_SELECT_ASSOC_BOOK_STATUS = 
            "SELECT BOOK_STATUS_ID, ASSOC_STATUS_BOOK_DATE, ASSOC_STATUS_BOOK_POST_IT "
            + "FROM "+TABLE_ASSOC_BOOK_STATUS+" "
            + "WHERE BOOK_ISBN = ?";
    public final String QUERY_SELECT_ASSOC_BOOK_KEYWORD = 
            "SELECT KEYWORD_ID FROM "+TABLE_ASSOC_BOOK_KEYWORD+" "
            + "WHERE BOOK_ISBN = ?";
    public final String QUERY_SELECT_ASSOC_BOOK_AUTHOR = 
            "SELECT AUTHOR_ID FROM "+TABLE_ASSOC_BOOK_AUTHOR+" "
            + "WHERE BOOK_ISBN = ?";
    public final String QUERY_SELECT_ASSOC_BOOK_CATEGORY = 
            "SELECT CATEGORY_ID FROM "+TABLE_ASSOC_BOOK_CATEGORY+" "
            + "WHERE BOOK_ISBN = ?";
    
    public final String QUERY_UPDATE_BOOK =
            "UPDATE "+TABLE_BOOK+" "
            + "SET PUBLISHER_ID = ?,"
            + "SET VAT_ID = ?,"
            + "BOOK_TITLE = ?,"
            + "BOOK_SUBTITLE = ?,"
            + "BOOK_HT_PRICE = ?,"
            + "BOOK_COVER_URL = ?,"
            + "BOOK_SUMMARY = ?,"
            + "BOOK_STOCK_QTY = ?,"
            + "BOOK_SHELF = ?,"
            + "BOOK_POST_IT = ?,"
            + "WHERE BOOK_ISBN = ?";
    
    public final String QUERY_DELETE_BOOK =
            "DELETE FROM BOOK WHERE ISBN = ?";
    
    
    @Override
    public void add(Book object) throws DatabaseException{
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);

            statement = connection.prepareStatement(QUERY_INSERT_BOOK_STATUS);

            statement.setString(1, object.getIsbn());
            statement.setInt(2, object.getPublisher().getId());

            result = statement.executeUpdate();

            statement.close();
            connection.close();
            
            JOptionPane.showMessageDialog(new JFrame(), "Nouveau livre enregistre dans BDD", "Livre insertion", 1, new ImageIcon(image2));

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void update(Book object) throws DatabaseException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Book object) throws DatabaseException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getAll() throws DatabaseException{
        List<Book> objects = new ArrayList<>();
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return objects;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_ALL_BOOK);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            Book object = null;
            
            while(resultSet.next()){
                
                object = new Book();
                object.setIsbn(resultSet.getString(1));
                
                // Obtains the publisher matching the ID
                object.setPublisher(new PublisherDAO().get(resultSet.getInt(2)));
                // Obtains the VAT matching the ID
                object.setVat(new VatDAO().get(resultSet.getInt(3)));
                object.setTitle(resultSet.getString(4));
                object.setSubTitle(resultSet.getString(5));
                object.setPrice(resultSet.getFloat(6));
                object.setCoverURL(resultSet.getString(7));
                object.setSummary(resultSet.getString(8));
                object.setQuantity(resultSet.getInt(9));
                object.setShelf(resultSet.getString(10));
                object.setPostIt(resultSet.getString(11));
                
                object.setCategories(getCategories(object.getIsbn()));
                object.setKeywords(getKeywords(object.getIsbn()));
                object.setAuthors(getAuthors(object.getIsbn()));
                object.setStatuses(getStatuses(object.getIsbn()));
                
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){

        }
        return objects;
    }

    @Override
    public Book get(Object id) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Keyword> getKeywords(String bookISBN) throws DatabaseException{
        
        List<Keyword> keywords = new ArrayList<>();
      
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_ASSOC_BOOK_KEYWORD);
            statement.setString(1, bookISBN);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                keywords.add(new KeywordDAO().get(resultSet.getInt(1)));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
        return keywords;
    }
    
    private List<Author> getAuthors(String bookISBN) throws DatabaseException{
        List<Author> authors = new ArrayList<>();
      
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_ASSOC_BOOK_AUTHOR);
            statement.setString(1, bookISBN);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                authors.add(new AuthorDAO().get(resultSet.getInt(1)));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
        return authors;
    }
    
    private List<Category> getCategories(String bookISBN) throws DatabaseException{
        List<Category> categories = new ArrayList<>();
      
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_ASSOC_BOOK_CATEGORY);
            statement.setString(1, bookISBN);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                categories.add(new CategoryDAO().get(resultSet.getInt(1)));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
        return categories;
    }

    private List<Book.BookStatusAssoc> getStatuses(String bookISBN) throws DatabaseException{
        List<Book.BookStatusAssoc> statuses = new ArrayList<>();
      
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_ASSOC_BOOK_STATUS);
            statement.setString(1, bookISBN);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
                Book.BookStatusAssoc assoc = new Book.BookStatusAssoc(
                        new BookStatusDAO().get(resultSet.getInt(1))
                );
                assoc.setAssocDate(resultSet.getString(2));
                assoc.setAssocPostIt(resultSet.getString(3));
                statuses.add(assoc);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
        return statuses;
    }
}
