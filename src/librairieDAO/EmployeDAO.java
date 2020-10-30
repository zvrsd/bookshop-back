/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librairieDAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import librairie.Employe;


/**
 *
 * @author cda611
 */
public class EmployeDAO {
    
    private String url; 
    private String username; 
    private String password; 
    Scanner sc = new Scanner(System.in);
    Connection connection;
    Employe employeComp;
 	ResultSet result;
 	Statement state;
	boolean check;
    
    public EmployeDAO(String url, String username, String password) throws SQLException{
        this.url = url; 
        this.username = username; 
        this.password = password; 
        
        connection = DriverManager.getConnection(url, username, password);
    }
    
    public EmployeDAO() throws SQLException{
        System.out.println("Entrez vos informations de connexion: \n "); 
        System.out.println("Url : \n");
         url = sc.nextLine(); 
        System.out.println("User : \n");
         username = sc.nextLine(); 
        System.out.println("password : \n");
         password = sc.nextLine(); 
         
         connection = DriverManager.getConnection(url, username, password);
        
    }
    
    public void SaveEmploye(Employe employe) throws SQLException{
         
        connection = DriverManager.getConnection(url, username, password);
                
            
	PreparedStatement prepare = connection.prepareStatement("insert into dbo.Employe VALUES(?,?,?);");
        
        prepare.setString(1, employe.getLogin());
        prepare.setString(2, employe.getPassword());
        prepare.setString(3, employe.getDateD_entree());
        
        prepare.execute();
				
	System.out.println(employe.getLogin() + " mis dans dbb");
		
	
	}
    
    public boolean checkEmploye(Employe employe) throws SQLException {
    
    	connection = DriverManager.getConnection(url, username, password);
    	 state = connection.createStatement();
    	 result = state.executeQuery("select * from dbo.Employe");
    
		while(result.next()) {
			
			 employeComp = new Employe(result.getString("EMPL_LOGIN"),result.getString("Empl_Password"));
			
			 if(employeComp.getPassword().equals(employe.getPassword())) 
				
			    	return true;}
		
		return false;	
    	
    }
    
    public static void main(String[] args) throws SQLException {
    	EmployeDAO e1 = new EmployeDAO("jdbc:sqlserver://localhost:1433;databaseName=BookShop;", "sa", "sa");
    	Employe emp1 = new Employe("Moui", "sa", "2004-05-23T14:25:10");
    	Employe emp2 = new Employe("cose", "poulet", "2004-05-23T14:25:10");
    	e1.SaveEmploye(emp2);
    }
}
