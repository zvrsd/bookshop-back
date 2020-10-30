package com.nope.bookshop.dao;

import com.nope.bookshop.entity.Category;
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
public class CategoryDAO implements DAO<Category>{

    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;

    public final String TABLE_CATEGORY = "CATEGORY";
    public final String TABLE_ASSOC_CATEGORY_CATEGORY = "ASSOC_CATEGORY_CATEGORY";
    
    public final String QUERY_SELECT_LAST_ID = "SELECT @@IDENTITY as ID";
    public final String QUERY_INSERT_CATEGORY =
            "INSERT INTO " + TABLE_CATEGORY
            + "(CATEGORY_NAME)"
            + " values"
            + "(?)";
    public final String QUERY_INSERT_ASSOC_CATEGORY_CATEGORY =
            "INSERT INTO " + TABLE_ASSOC_CATEGORY_CATEGORY
            + "(CATEGORY_PARENT_ID, CATEGORY_CHILD_ID)"
            + " values"
            + "(?,?)";
    public final String QUERY_SELECT_ALL_CATEGORY = "SELECT * FROM CATEGORY";
    public final String QUERY_SELECT_CATEGORY = 
            "SELECT * FROM CATEGORY "
            + "WHERE CATEGORY_ID = ?";
    
    public final String QUERY_SELECT_ALL_ASSOC_CATEGORY_CATEGORY = 
            "SELECT * FROM "+TABLE_ASSOC_CATEGORY_CATEGORY;
    public final String QUERY_SELECT_ALL_ASSOC_WHERE_ID = 
            QUERY_SELECT_ALL_ASSOC_CATEGORY_CATEGORY+" "
            + "WHERE CATEGORY_PARENT_ID = ?";
    
    public final String QUERY_CHECK_ASSOC =
            "SELECT 1 FROM ASSOC_CATEGORY_CATEGORY WHERE "
            + "CATEGORY_PARENT_ID = ? AND "
            + "CATEGORY_CHILD_ID = ?";
    
    public final String QUERY_UPDATE_CATEGORY =
            "UPDATE CATEGORY SET CATEGORY_NAME=? WHERE CATEGORY_ID = ?";
    public final String QUERY_DELETE_CATEGORY = 
            "DELETE FROM CATEGORY WHERE CATEGORY_ID = ?";
    public final String QUERY_DELETE_ASSOC_CATEGORY_CATEGORY = 
            "DELETE FROM "+TABLE_ASSOC_CATEGORY_CATEGORY+" WHERE "
            + "CATEGORY_PARENT_ID = ? AND "
            + "CATEGORY_CHILD_ID = ?";
    

    public CategoryDAO(){
        
    }
    
    @Override
    public void delete(Category object) throws DatabaseException {
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_DELETE_CATEGORY);
            statement.setInt(1, object.getId());
            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void add(Category object) throws DatabaseException {

        Connection connection;
        PreparedStatement statement;
        int result = -1;
        int elementID = -1;
        ResultSet resultSet;
        
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_INSERT_CATEGORY);
            statement.setString(1, object.getName());
            result = statement.executeUpdate();
            
            // Get the ID of the element we've just inserted
            statement = connection.prepareStatement(QUERY_SELECT_LAST_ID);
            resultSet = statement.executeQuery();
            resultSet.next();
            elementID = resultSet.getInt(1);
            object.setId(elementID);

            addAssociations(connection, object);
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void update(Category object) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_CATEGORY);

            statement.setString(1, object.getName());
            statement.setInt(2, object.getId());
            result = statement.executeUpdate();
            
            addAssociations(connection, object);
            removeAssociations(connection, object);

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public List<Category> getAll() {
        
        List<Category> categories = new ArrayList<>();
        List<int[]> associations = new ArrayList<>();
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return categories;
        }

        try{
            statement = connection.prepareStatement(QUERY_SELECT_ALL_CATEGORY);
            resultSet = statement.executeQuery();

            Category category = null;
            while(resultSet.next()){

                category = new Category();
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));

                categories.add(category);
            }

            statement = connection.prepareStatement(
                QUERY_SELECT_ALL_ASSOC_CATEGORY_CATEGORY
            );
            resultSet = statement.executeQuery();

            while(resultSet.next()){

                int[] association = new int[2];
                association[0] = resultSet.getInt(1);
                association[1] = resultSet.getInt(2);

                associations.add(association);
            }

            for(int[] association : associations){
                for(Category cParent : categories){
                    if(cParent.getId() == association[0]){
                        for(Category cEnfant : categories){
                            if(cEnfant.getId() == association[1]){
                                cParent.getCategories().add(cEnfant);
                            }
                        }
                    }
                }
            }

            statement.close();
            connection.close();

        }catch(SQLException ex){
        }

        return categories;
    }
    
    /**
     * Checks if the specified object is associated to another in the database
     * 
     * @param connection
     * @param object
     * @return
     * @throws SQLException 
     */
    private boolean hasAssociation(Connection connection, Category object, Category subCategory) throws SQLException{
        
        PreparedStatement statement;
        ResultSet resultSet;

        // Check if the association already exists
        statement = connection.prepareStatement(QUERY_CHECK_ASSOC);
        statement.setInt(1, object.getId());
        statement.setInt(2, subCategory.getId());
        resultSet = statement.executeQuery();

        //System.out.println("checking assoc "+object.getId()+" - "+subCategory.getId());
        // Returns true is there is a result
        return resultSet.next();
    }
    
    private void addAssociations(Connection connection, Category object) throws SQLException{
          
        PreparedStatement statement;
        
        for(Category subCategory : object.getCategories()){
            
            if(!hasAssociation(connection, object, subCategory)){
                //System.out.println("add assoc");
                statement = connection.prepareStatement(QUERY_INSERT_ASSOC_CATEGORY_CATEGORY);
                statement.setInt(1, object.getId());
                statement.setInt(2, subCategory.getId());
                statement.executeUpdate();
                //System.out.println("assoc added");
            }
        }
    }
    
    /**
     * Removes unwanted categories associations
     * 
     * @param connection
     * @param object
     * @throws SQLException 
     */
    private void removeAssociations(Connection connection, Category object) throws SQLException{
        
        PreparedStatement statement;
        ResultSet resultSet;

        statement = connection.prepareStatement(QUERY_SELECT_ALL_ASSOC_WHERE_ID);
        statement.setInt(1, object.getId());
        resultSet = statement.executeQuery();

        while (resultSet.next()) {

            boolean isValid = false;
            
            for (Category subCategory : object.getCategories()) {
                //System.out.println("chekin "+subCategory.getId()+""+resultSet.getInt(2));
                if (resultSet.getInt(2) == subCategory.getId()) {
                    //System.out.println("check valid"+subCategory.getId()+""+resultSet.getInt(2));
                    isValid = true;
                }
            }
            if(!isValid){
                statement = connection.prepareStatement(QUERY_DELETE_ASSOC_CATEGORY_CATEGORY);
                statement.setInt(1, object.getId());
                statement.setInt(2, resultSet.getInt(2));
                statement.executeUpdate();
                //System.out.println("need to remove "+object.getId()+""+resultSet.getInt(2));
            }
            
        }
    }

    @Override
    public Category get(Object id) throws DatabaseException {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        Category category = new Category();
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return category;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_CATEGORY);
            statement.setInt(1, (int)id);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            while(resultSet.next()){
                
                category = new Category();
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return category;
    }
}
