package com.nope.bookshop.dao;


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
public class KeywordDAO implements DAO<Keyword>{

    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;

final ImageIcon icon = new ImageIcon("icone.png");
	    Image image2 = icon.getImage().getScaledInstance(32,32,0);

    public final String TABLE_KEYWORD = "KEYWORD";
    
    public final String QUERY_INSERT_KEYWORD =
            "INSERT INTO " + TABLE_KEYWORD
            + "(KEYWORD_NAME)"
            + " values"
            + "(?)";
    
    public final String QUERY_SELECT_ALL_KEYWORD = "SELECT * FROM KEYWORD";
    public final String QUERY_SELECT_KEYWORD = 
            "SELECT * FROM KEYWORD "
            + "WHERE KEYWORD_ID = ?";
    public final String QUERY_UPDATE_KEYWORD =
            "UPDATE KEYWORD SET KEYWORD_NAME=? WHERE KEYWORD_ID = ?";
    public final String QUERY_DELETE_KEYWORD = 
            "DELETE FROM KEYWORD WHERE KEYWORD_ID = ?";
    
    
    public KeywordDAO(){
    }
    
    
    /**
     * Adds a keyword into the database 
     * 
     * @param keyword The keyword to add
     * @throws com.nope.bookshop.exception.DatabaseException
     */
    @Override
    public void add(Keyword keyword) throws DatabaseException{
        
        Connection connection;
        PreparedStatement statement;
        int result = -1;
        
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_INSERT_KEYWORD);

            statement.setString(1, keyword.getName());

            result = statement.executeUpdate();
            
            statement.close();
            connection.close();

            JOptionPane.showMessageDialog(new JFrame(), "Mot-clef dans Bdd", "Mots-clefs", 1, new ImageIcon(image2));
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }
   
    /**
     * Obtains all keywords from the database
     * 
     * @return A List containing all keywords
     */
    @Override
    public List<Keyword> getAll(){
        
        List<Keyword> objects = new ArrayList<>();
        
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
            statement = connection.prepareStatement(QUERY_SELECT_ALL_KEYWORD);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            Keyword object = null;
            
            while(resultSet.next()){
                
                object = new Keyword();
                object.setId(resultSet.getInt(1));
                object.setName(resultSet.getString(2));
                
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){

        }
        return objects;
    }
    
    /**
     * Deletes a keyword based on its ID
     * 
     * @param object The keyword to delete from the database
     * @throws com.nope.bookshop.exception.DatabaseException
     */
    @Override
    public void delete(Keyword object) throws DatabaseException{

        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_DELETE_KEYWORD);
            statement.setInt(1, object.getId());
            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    /**
     * Updates a keyword
     * @param object The keyword to update
     * @throws com.nope.bookshop.exception.DatabaseException
     */
    @Override
    public void update(Keyword object) throws DatabaseException{
        
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_KEYWORD);

            statement.setString(1, object.getName());
            statement.setInt(2, object.getId());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    /**
     * Obtains a keyword matching the specified from the database
     * 
     * @param id
     * @return
     * @throws DatabaseException 
     */
    @Override
    public Keyword get(Object id) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        Keyword keyword = new Keyword();
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return keyword;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_KEYWORD);
            statement.setInt(1, (int)id);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            while(resultSet.next()){
                
                keyword = new Keyword();
                keyword.setId(resultSet.getInt(1));
                keyword.setName(resultSet.getString(2));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return keyword;
    }
}