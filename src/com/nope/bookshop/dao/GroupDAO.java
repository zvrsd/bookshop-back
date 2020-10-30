/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nope.bookshop.dao;

import com.nope.bookshop.entity.Group;
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
 * @author Cy
 */
public class GroupDAO implements DAO<Group>{


    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;

    public final String TABLE_GROUP = "GROUP";
    
    public final String QUERY_INSERT_GROUP =
            "INSERT INTO " + TABLE_GROUP
            + "(GROUP_ID, GROUP_NAME)"
            + " values"
            + "(?,?)";
    
    public final String QUERY_SELECT_ALL_GROUP = "SELECT * FROM GROUP";
    public final String QUERY_SELECT_GROUP = 
            "SELECT * FROM GROUP "
            + "WHERE GROUP_ID = ?";
    
    public final String QUERY_UPDATE_GROUP =
            "UPDATE KEYWORD "
            + "SET GROUP_NAME=?, "
            + "WHERE GROUP_ID = ?";
    
    public final String QUERY_DELETE_GROUP = 
            "DELETE FROM GROUP WHERE GROUP_ID = ?";

    public void add(Group object) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        int result = -1;
        
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_INSERT_GROUP);

            statement.setString(1, object.getGroupName());
            
            result = statement.executeUpdate();
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    public void update(Group object) throws DatabaseException {
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_GROUP);

            statement.setString(1, object.getGroupName());
            statement.setInt(4, object.getGroupId());
            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void delete(Group object) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Group> getAll() throws DatabaseException {
        
        List<Group> objects = new ArrayList<>();
        
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
            statement = connection.prepareStatement(QUERY_SELECT_ALL_GROUP);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            Group object = null;
            
            while(resultSet.next()){
                
                object = new Group();
                object.setGroupId(resultSet.getInt(1));
                object.setGroupName(resultSet.getString(2));
                
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){

        }
        return objects;
    }

    @Override
    public Group get(Object groupId) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        Group group = new Group();
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return group;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_GROUP);
            statement.setInt(1, (int)groupId);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            while(resultSet.next()){
                
                group = new Group();
                group.setGroupId(resultSet.getInt(1));
                group.setGroupName(resultSet.getString(2));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return group;
    }
}