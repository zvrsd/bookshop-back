package com.nope.bookshop.dao;

import com.nope.bookshop.db.ConnectionDAO;
import com.nope.bookshop.db.DBConnection;
import com.nope.bookshop.entity.Employee;
import com.nope.bookshop.exception.DatabaseException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cy
 */
public class EmployeeDAO implements DAO<Employee>{

    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;

    public final String TABLE_EMPLOYEE = "EMPLOYEE";
    
    public final String QUERY_INSERT_EMPLOYEE =
            "INSERT INTO " + TABLE_EMPLOYEE
            + "(EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END)"
            + " values"
            + "(?,?,?,?)";
    
    public final String QUERY_SELECT_ALL_EMPLOYEE = "SELECT * FROM EMPLOYEE";
    
    public final String QUERY_SELECT_EMPLOYEE = 
            "SELECT * FROM EMPLOYEE "
            + "WHERE EMPLOYEE_ID = ?";
    
    public final String QUERY_UPDATE_EMPLOYEE =
            "UPDATE EMPLOYEE "
            + "SET EMPLOYEE_LOGIN=?, "
            + " EMPLOYEE_PASSWORD=?, "
            + " EMPLOYEE_DATE_START=?, "
            + " EMPLOYEE_DATE_END=? "
            + "WHERE EMPLOYEE_ID = ?";
    
    public final String QUERY_DELETE_EMPLOYEE = 
            "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
    
    public final String QUERY_LOGIN_PROCESS = 
            "SELECT * FROM EMPLOYEE "
            + " WHERE EMPLOYEE_LOGIN = ? AND EMPLOYEE_PASSWORD = ?";
    
    @Override
    public void add(Employee object) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        int result = -1;
        
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_INSERT_EMPLOYEE);

            statement.setString(1, object.getEmployeeLogin());
            statement.setString(2, object.getEmployeePassword());
            statement.setString(3, object.getEmployeeDateStart());
            statement.setString(4, object.getEmployeeDateEnd());

            result = statement.executeUpdate();
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void update(Employee object) throws DatabaseException {
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_EMPLOYEE);

            statement.setString(1, object.getEmployeeLogin());
            statement.setString(2, object.getEmployeePassword());
            statement.setString(3, object.getEmployeeDateStart());
            statement.setString(4, object.getEmployeeDateEnd());
            statement.setInt(5, object.getEmployeeId());
            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

//    public List<Employee> list(){
//                 List<Employee> listEmployee = new ArrayList();
//         
//        try {
//            ConnectionDAO connecter = new ConnectionDAO();
//            Connection connect = connecter.Connecter();
//            
//            
//            PreparedStatement preparedStatement = connect.prepareStatement("SELECT * from EMPLOYEE");
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            
//            
//            while (resultSet.next()) {
//                
//                int employeeId = resultSet.getInt(1);
//                String employeeLogin = resultSet.getString(2);
//                String employeePassword = resultSet.getString(3);
//                String employeeDateStart = resultSet.getString(4);
//                String employeeDateEnd = resultSet.getString(5);
//                
//                Employee employee = new Employee(employeeId, employeeLogin, employeePassword, employeeDateStart, employeeDateEnd);
//               
//                
//                listEmployee.add(employee);
//                
//                               
//            }
//            connect.close();
//            preparedStatement.close();
//            
//            
//            
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//       return listEmployee;
//        
//             
//    }
    @Override
    public void delete(Employee object) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       @Override
    public List<Employee> getAll() throws DatabaseException {
        
        List<Employee> objects = new ArrayList<>();
        
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
            statement = connection.prepareStatement(QUERY_SELECT_ALL_EMPLOYEE);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            Employee object = null;
            
            while(resultSet.next()){
                
                object = new Employee();
                object.setEmployeeId(resultSet.getInt(1));
                object.setEmployeeLogin(resultSet.getString(2));
                object.setEmployeePassword(resultSet.getString(3));
                object.setEmployeeDateStart(resultSet.getString(4));
                object.setEmployeeDateEnd(resultSet.getString(5));
                
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){

        }
        return objects;
    }

    @Override
    public Employee get(Object employeeId) throws DatabaseException {
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        Employee employee = new Employee();
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return employee;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_EMPLOYEE);
            statement.setInt(1, (int)employeeId);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            while(resultSet.next()){
                
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeLogin(resultSet.getString(2));
                employee.setEmployeePassword(resultSet.getString(3));
                employee.setEmployeeDateStart(resultSet.getString(4));
                employee.setEmployeeDateEnd(resultSet.getString(5));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return employee;
    }
    
   public Employee getLogin(Employee employee) throws DatabaseException {
        
        Connection connection = null;
        PreparedStatement statement;
        ResultSet resultSet;
        
        Employee em = new Employee();
               
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        return em;
        }
        
        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_LOGIN_PROCESS);
//                    ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
                    
                statement.setString(1, employee.getEmployeeLogin());
                statement.setString(2, employee.getEmployeePassword());
//            statement.getResultSet();
            resultSet = statement.executeQuery();
                        
            // Creates objects based on the query results
            while(resultSet.next()){
                
                em = new Employee();
                em.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
                em.setEmployeeLogin(resultSet.getString("EMPLOYEE_LOGIN"));
                em.setEmployeePassword(resultSet.getString("EMPLOYEE_PASSWORD"));
                em.setEmployeeDateStart(resultSet.getString("EMPLOYEE_DATE_START"));
                em.setEmployeeDateEnd(resultSet.getString("EMPLOYEE_DATE_END"));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException exe){
            System.out.println(exe.getMessage());
            return em;
        }
        
        return em;
    }

 
}
