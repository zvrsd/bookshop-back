package com.nope.bookshop.dao;

import com.nope.bookshop.exception.DatabaseException;

import com.nope.bookshop.entity.BookStatus;

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
public class BookStatusDAO implements DAO<BookStatus>{

    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;
    final ImageIcon icon = new ImageIcon("icone.png");
    Image image2 = icon.getImage().getScaledInstance(32,32,0);

    public final String TABLE_BOOK_STATUS = "BOOK_STATUS";
    
    public final String QUERY_INSERT_BOOK_STATUS =
            "INSERT INTO " + TABLE_BOOK_STATUS
            + "(BOOK_STATUS_NAME, BOOK_STATUS_POST_IT)"
            + " values"
            + "(?,?)";
    
    public final String QUERY_SELECT_ALL_BOOK_STATUS = 
            "SELECT * FROM "+TABLE_BOOK_STATUS;
    
    public final String QUERY_SELECT_BOOK_STATUS = 
            "SELECT * FROM "+TABLE_BOOK_STATUS+" "
            + "WHERE BOOK_STATUS_ID = ?";
    
    public final String QUERY_UPDATE_BOOK_STATUS =
            "UPDATE "+TABLE_BOOK_STATUS+" "
            + "SET BOOK_STATUS_NAME=?,"
            + "BOOK_STATUS_POST_IT=? "
            + "WHERE BOOK_STATUS_ID = ?";
    
    public final String QUERY_DELETE_BOOK_STATUS =
            "DELETE FROM BOOK_STATUS WHERE BOOK_STATUS_ID = ?";
    
    
    @Override
    public void add(BookStatus object) throws DatabaseException{
        
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);

            statement = connection.prepareStatement(QUERY_INSERT_BOOK_STATUS);

            statement.setString(1, object.getName());
            statement.setString(2, object.getPostIt());

            result = statement.executeUpdate();

            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(new JFrame(), "Statut dans BDD", "Statut livre", 1, new ImageIcon(image2));

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void update(BookStatus object) throws DatabaseException{
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_BOOK_STATUS);

            statement.setString(1, object.getName());
            statement.setString(2, object.getPostIt());
            statement.setInt(3, object.getId());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void delete(BookStatus object) throws DatabaseException{
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_DELETE_BOOK_STATUS);
            statement.setInt(1, object.getId());
            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public List<BookStatus> getAll() {
        List<BookStatus> objects = new ArrayList<>();
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return null;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_ALL_BOOK_STATUS);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            BookStatus object = null;
            
            while(resultSet.next()){
                
                object = new BookStatus();
                object.setId(resultSet.getInt(1));
                object.setName(resultSet.getString(2));
                object.setPostIt(resultSet.getString(3));
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
        }

        return objects;
    }

    @Override
    public BookStatus get(Object id) throws DatabaseException {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        BookStatus bookStatus = new BookStatus();
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return bookStatus;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_BOOK_STATUS);
            statement.setInt(1, (int)id);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            while(resultSet.next()){
                
                bookStatus = new BookStatus();
                bookStatus.setId(resultSet.getInt(1));
                bookStatus.setName(resultSet.getString(2));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return bookStatus;
    }
}
