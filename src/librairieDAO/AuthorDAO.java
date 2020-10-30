/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librairieDAO;



import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import librairie.Author;




public class AuthorDAO {
	
		private String url ; 
	    private String username ; 
	    private String password ; 
	    Scanner sc = new Scanner(System.in);
	    private Connection connection;
	 	private ResultSet result;
	 	private Statement state;
	 	ResultSetMetaData resultMeta;
	 	PreparedStatement prepare;
	 	boolean exist;
	 	String query;
	 
	 	 String nom ;
	 	String prenom ;

	 	   public AuthorDAO(String url, String username, String password) throws SQLException{
	 	        this.url = url; 
	 	        this.username = username; 
	 	        this.password = password; 
	 	      
	 	        connection = DriverManager.getConnection(url, username, password);
	 	    }
	 	    
	 	   public AuthorDAO() throws SQLException{
	 	        System.out.println("Entrez vos informations de connexion: \n "); 
	 	        System.out.println("Url : \n");
	 	         url = sc.nextLine(); 
	 	        System.out.println("User : \n");
	 	         username = sc.nextLine(); 
	 	        System.out.println("password : \n");
	 	         password = sc.nextLine(); 
	 	         
	 	         connection = DriverManager.getConnection(url, username, password);
	 	        
	 	    }
	 	    
	 	   public void SaveAuthor(Author auteur) throws SQLException{
	 
	 	        connection = DriverManager.getConnection(url, username, password);
	 	       String query = "SELECT author_l_name, author_f_name from Author where author_l_name = '"+auteur.getName()+"'";
	 	       
	  
	 	      // String query = "SELECT * from Auteur"; 
	 	       state = connection.createStatement();
	 	       result = state.executeQuery(query);
	 	      resultMeta = result.getMetaData();
	 	      
	 	      if (result.next()){  
	 	    	  
	 	    	
		 	      prenom = result.getString("author_f_name");
		 	      
	 	       if ((prenom.equals(auteur.getFirstname()))) {
	 	    	  JOptionPane.showMessageDialog(new JFrame(), "Auteur déjà enregistré");
	 	    	   exist = true;}
	 	    	  
	 	       }else {
	 	    	  prepare = connection.prepareStatement("insert into dbo.Author VALUES(?,?,?);");
		 	 		 
			 	  
		 	        prepare.setString(1, auteur.getName());
		 	        prepare.setString(2, auteur.getFirstname());
		 	        prepare.setString(3, auteur.getPostIt());
		 	        
		 	        prepare.execute();
		 					
		 		JOptionPane.showMessageDialog(new JFrame(), auteur.getName() + " mis dans dbb");}}
	 	   
	 	   public Long getId(Author auteur) throws SQLException {
	 		   
	 		   connection = DriverManager.getConnection(url, username, password);
	 	       String query = "SELECT * from Author where author_l_name = '"+auteur.getName()+"'";
	 	       
	  
	 	      // String query = "SELECT * from Author"; 
	 	       state = connection.createStatement();
	 	       result = state.executeQuery(query);
	 	      resultMeta = result.getMetaData();
	 	      
	 	      if (result.next()){  
	 	    	  
	 	    	System.out.println(result.getLong(1));
		 	    return result.getLong(1);
	 	      }
	 	     System.out.println("Auteur inexistant !");
	 	    	return 0l;  
	 	      
	 	   }
	 	   
	 	
	 	  public void createAuthor(Author author) {
	 		   
	 		  
	 		   try {
				SaveAuthor(author);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
}
                  
                  public List authorList(){
                      
                      List<Author> authorl = new ArrayList<>(); 
                      
                       try {
		connection = DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       String query = "SELECT * from Author ";
       try {
		state = connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       try {
		result = state.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       try {
		while (result.next()) {
			authorl.add(new Author(result.getString("AUTHOR_L_NAME"), result.getString("AUTHOR_F_NAME"), result.getString("AUTHOR_POST_IT")));
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return authorl;
                  }
}
