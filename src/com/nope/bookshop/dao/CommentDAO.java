/*
 * Le DAO pour la table Comment mais toutes les autres associations aussi
*/
package com.nope.bookshop.dao;

 

import com.nope.bookshop.entity.Comment;
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
public abstract class CommentDAO implements DAO<Comment>{


    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;

    public final String TABLE_COMMENT = "COMMENT";
    
    // Here are the associations tables:
    public final String TABLE_COMMENT_STATUS = "COMMENT_STATUS";
    public final String TABLE_ASSOC_STATUS_COMMENT = "ASSOC_STATUS_COMMENT";
    public final String TABLE_ASSOC_COMMENT_EMPLOYEE = "ASSOC_COMMENT_EMPLOYEE";
    public final String TABLE_ASSOC_BOOK_STATUS = "ASSOC_BOOK_STATUS";
    public final String TABLE_ORDER_ROW = "TABLE_ORDER_ROW";
    
    public final String QUERY_INSERT_BOOK_STATUS =
            "INSERT INTO " + TABLE_COMMENT
            + "(COMMENT_ID, CUSTOMER_ID, ORDER_ROW_ID, BOOK_ISBN, COMMENT_TITLE, COMMENT_RATING,"
            + "COMMENT_TEXT, COMMENT_DATE, COMMENT_USER_IP, COMMENT_EDIT_DATE)"
            + " values"
            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, )";
    
    public final String QUERY_SELECT_ALL_COMMENT = 
            "SELECT * FROM "+TABLE_COMMENT;
    
    public final String QUERY_SELECT_COMMENT_STATUS = 
            "SELECT COMMENT_STATUS_ID, COMMENT_STATUS_BOOK_DATE, ASSOC_STATUS_BOOK_POST_IT "
            + "FROM "+TABLE_COMMENT_STATUS+" "
            + "WHERE COMMENT_STATUS_ID = ?";
    
    public final String QUERY_SELECT_ASSOC_STATUS_COMMENT = 
            "SELECT COMMENT_ID FROM "+TABLE_ASSOC_STATUS_COMMENT+" "
            + "WHERE BOOK_ISBN = ?";
    
    public final String QUERY_SELECT_ASSOC_COMMENT_EMPLOYEE = 
            "SELECT EMPLOYEE_ID FROM "+TABLE_ASSOC_COMMENT_EMPLOYEE+" "
            + "WHERE COMMENT_ID = ?";
    
    public final String QUERY_SELECT_ASSOC_BOOK_STATUS =
            "SELECT BOOK_ISBN FROM "+TABLE_ASSOC_BOOK_STATUS+" "
            + "WHERE COMMENT_ID = ?";
    
    public final String QUERY_SELECT_ORDER_ROW =
            "SELECT ORDER_ROW_ID FROM"+TABLE_ORDER_ROW+" "
            + "WHERE COMMENT_ID = ?";
    
    public final String QUERY_UPDATE_COMMENT =
            "UPDATE "+TABLE_COMMENT+" "
            + "SET COMMENT_ID = ?,"
            + "SET CUSTOMER_ID = ?,"
            + "SET ORDER_ROW_ID = ?,"
            + "SET BOOK_ISBN = ?,"
            + "COMMENT_TITLE= ?,"
            + "COMMENT_RATING = ?,"
            + "COMMENT_TEXT = ?,"
            + "COMMENT_DATE = ?,"
            + "COMMENT_USER_IP = ?,"
            + "COMMENT_EDIT_DATE = ?,";
    
    public final String QUERY_DELETE_COMMENT =
            "DELETE FROM COMMENT WHERE COMMENT_ID = ?";
    
    @Override
    public void add(Comment object){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Comment object){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Comment object){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comment> getAll() throws DatabaseException{
        List<Comment> objects = new ArrayList<>();
        
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
            statement = connection.prepareStatement(QUERY_SELECT_ALL_COMMENT);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            Comment object = null;
            
            while(resultSet.next()){
                
                object = new Comment();
                object.setCommentId(resultSet.getInt(1));
                
                // Obtains the customer matching the ID
//                object.setCustomerID(new CommentDAO().get(resultSet.getInt(2)));
                // Obtains the Order Row matching the ID
//               object.setOrderRowId(new CommentDAO().get(resultSet.getInt(3)));
//                object.setIsbn(resultSet.getString(4));
                object.setCommentTitle(resultSet.getString(5));
                object.setCommentRating(resultSet.getInt(6));
                object.setCommentText(resultSet.getString(7));
                object.setCommentDate(resultSet.getString(8));
                object.setCommentUserIp(resultSet.getString(9));
                object.setCommentEditDate(resultSet.getString(10));
                
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){

        }
        return objects;
    }
}
