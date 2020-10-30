/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nope.bookshop.dao;

/**
 *
 * @author Cy
 */
import com.nope.bookshop.entity.Permission;
import com.nope.bookshop.exception.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PermissionDAO implements DAO<Permission>{

    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;

    public final String TABLE_PERMISSION = "PERMISSION";
    
    public final String QUERY_INSERT_PERMISSION =
            "INSERT INTO " + TABLE_PERMISSION
            + "(PERMISSION_ID, PERMISSION_NAME)"
            + " values"
            + "(?,?)";
    
    public final String QUERY_SELECT_ALL_PERMISSION = "SELECT * FROM PERMISSION";
    public final String QUERY_SELECT_PERMISSION = 
            "SELECT * FROM PERMISSION "
            + "WHERE PERMISSION_ID = ?";
    public final String QUERY_UPDATE_PERMISSION =
            "UPDATE KEYWORD "
            + "SET PERMISSION_NAME=?, "
            + "WHERE PERMISSION_ID = ?";
    public final String QUERY_DELETE_PERMISSION = 
            "DELETE FROM PERMISSION WHERE PERMISSION_ID = ?";

    public void add(Permission object) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        int result = -1;
        
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_INSERT_PERMISSION);

            statement.setString(1, object.getPermissionName());

            result = statement.executeUpdate();
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    public void update(Permission object) throws DatabaseException {
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_PERMISSION);

            statement.setString(1, object.getPermissionName());
            statement.setInt(2, object.getPermissionId());
            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void delete(Permission object) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Permission> getAll() throws DatabaseException {
        
        List<Permission> objects = new ArrayList<>();
        
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
            statement = connection.prepareStatement(QUERY_SELECT_ALL_PERMISSION);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            Permission object = null;
            
            while(resultSet.next()){
                
                object = new Permission();
                object.setPermissionId(resultSet.getInt(1));
                object.setPermissionName(resultSet.getString(2));
                                
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){

        }
        return objects;
    }

    @Override
    public Permission get(Object permissionId) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        Permission permission = new Permission();
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return permission;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_PERMISSION);
            statement.setInt(1, (int)permissionId);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            while(resultSet.next()){
                
                permission = new Permission();
                permission.setPermissionId(resultSet.getInt(1));
                permission.setPermissionName(resultSet.getString(2));
             }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return permission;
    }
}