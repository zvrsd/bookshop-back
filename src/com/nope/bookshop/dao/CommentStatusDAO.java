/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nope.bookshop.dao;

import com.nope.bookshop.entity.CommentStatus;
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
public class CommentStatusDAO implements DAO<CommentStatus> {


    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;

    public final String TABLE_COMMENT_STATUS = "COMMENT_STATUS";
    
    public final String QUERY_INSERT_COMMENT_STATUS =
            "INSERT INTO " + TABLE_COMMENT_STATUS
            + "(COMMENT_STATUS_NAME, COMMENT_STATUS_POST_IT)"
            + " values"
            + "(?,?)";
    
    public final String QUERY_SELECT_ALL_COMMENT_STATUS = "SELECT * FROM COMMENT_STATUS";
    public final String QUERY_SELECT_COMMENT_STATUS = 
            "SELECT * FROM COMMENT_STATUS "
            + "WHERE COMMENT_STATUS_ID = ?";
    
    public final String QUERY_UPDATE_COMMENT_STATUS =
            "UPDATE KEYWORD "
            + "SET COMMENT_STATUS_NAME=?, "
            + "SET COMMENT_STATUS_POST_IT=?, "
            + "WHERE COMMENT_STATUS_ID = ?";
    
    public final String QUERY_DELETE_COMMENT_STATUS = 
            "DELETE FROM COMMENT_STATUS WHERE COMMENT_STATUS_ID = ?";

    public void add(CommentStatus object) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        int result = -1;
        
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_INSERT_COMMENT_STATUS);

            statement.setString(1, object.getCommentStatusName());
            statement.setString(2, object.getCommentStatusPostIt());

            result = statement.executeUpdate();
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    public void update(CommentStatus object) throws DatabaseException {
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_COMMENT_STATUS);

            statement.setString(1, object.getCommentStatusName());
            statement.setString(2, object.getCommentStatusPostIt());
            statement.setInt(4, object.getCommentStatusId());
            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void delete(CommentStatus object) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommentStatus> getAll() throws DatabaseException {
        
        List<CommentStatus> objects = new ArrayList<>();
        
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
            statement = connection.prepareStatement(QUERY_SELECT_ALL_COMMENT_STATUS);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            CommentStatus object = null;
            
            while(resultSet.next()){
                
                object = new CommentStatus();
                object.setCommentStatusId(resultSet.getInt(1));
                object.setCommentStatusName(resultSet.getString(2));
                object.setCommentStatusPostIt(resultSet.getString(3));
              
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){

        }
        return objects;
    }

    @Override
    public CommentStatus get(Object commentStatusId) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        CommentStatus commentStatus = new CommentStatus();
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return commentStatus;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_COMMENT_STATUS);
            statement.setInt(1, (int)commentStatusId);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            while(resultSet.next()){
                
                commentStatus = new CommentStatus();
                commentStatus.setCommentStatusId(resultSet.getInt(1));
                commentStatus.setCommentStatusName(resultSet.getString(2));
                commentStatus.setCommentStatusPostIt(resultSet.getString(3));
        }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return commentStatus;
    }
}  

