package com.nope.bookshop.dao;

import com.nope.bookshop.entity.Author;
import com.nope.bookshop.exception.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zvr
 */
public class AuthorDAO implements DAO<Author>{

    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;

    public final String TABLE_AUTHOR = "AUTHOR";
    
    public final String QUERY_INSERT_AUTHOR =
            "INSERT INTO " + TABLE_AUTHOR
            + "(AUTHOR_F_NAME, AUTHOR_L_NAME, AUTHOR_POST_IT)"
            + " values"
            + "(?,?,?)";
    
    public final String QUERY_SELECT_ALL_AUTHOR = "SELECT * FROM AUTHOR";
    public final String QUERY_SELECT_AUTHOR = 
            "SELECT * FROM AUTHOR "
            + "WHERE AUTHOR_ID = ?";
    public final String QUERY_UPDATE_AUTHOR =
            "UPDATE KEYWORD "
            + "SET AUTHOR_F_NAME=?, "
            + "SET AUTHOR_L_NAME=?, "
            + "SET AUTHOR_POST_IT=? "
            + "WHERE AUTHOR_ID = ?";
    public final String QUERY_DELETE_AUTHOR = 
            "DELETE FROM AUTHOR WHERE AUTHOR_ID = ?";

    @Override
    public void add(Author object) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        int result = -1;
        
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_INSERT_AUTHOR);

            statement.setString(1, object.getFristName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getPostIt());

            result = statement.executeUpdate();
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void update(Author object) throws DatabaseException {
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_AUTHOR);

            statement.setString(1, object.getFristName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getPostIt());
            statement.setInt(4, object.getId());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void delete(Author object) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Author> getAll() throws DatabaseException {
        
        List<Author> objects = new ArrayList<>();
        
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
            statement = connection.prepareStatement(QUERY_SELECT_ALL_AUTHOR);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            Author object = null;
            
            while(resultSet.next()){
                
                object = new Author();
                object.setId(resultSet.getInt(1));
                object.setFristName(resultSet.getString(2));
                object.setLastName(resultSet.getString(3));
                object.setPostIt(resultSet.getString(4));
                
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){

        }
        return objects;
    }

    @Override
    public Author get(Object id) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        Author author = new Author();
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return author;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_AUTHOR);
            statement.setInt(1, (int)id);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            while(resultSet.next()){
                
                author = new Author();
                author.setId(resultSet.getInt(1));
                author.setFristName(resultSet.getString(2));
                author.setLastName(resultSet.getString(3));
                author.setPostIt(resultSet.getString(4));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return author;
    }
}