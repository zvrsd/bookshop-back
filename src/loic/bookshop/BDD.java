
package bookshop;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Exception;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDD {
    
  static Statement state;
  static ResultSet result;
  static ResultSetMetaData resultMeta;
  
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost;"
                + "databaseName=bookshop;user=sa;password=sa";
        Connection connect = null;

        System.out.println("Lancement ");

        try {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                System.out.println("co réussie");
            } catch (Exception e) {
                System.out.println("échec driver");
            }
            connect = DriverManager.getConnection(connectionUrl);
            System.out.println("ok");

            System.out.println("Réussie");
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Echec");
        }
        
        try{
         state = connect.createStatement();
         }catch (SQLException e){
        System.out.println(e.getMessage());}
        try{
                 result = state.executeQuery("SELECT * from BOOK");
                 }catch (SQLException ef){
        System.out.println(ef.getMessage());}
        try{
                 resultMeta = result.getMetaData();
                 }catch (SQLException ref){
        System.out.println(ref.getMessage());}
                
                 System.out.println("\n******getObject()************\n");
                 try{
        for(int i = 1; i <= resultMeta.getColumnCount()  ; i++)
            System.out.println("\t" + result.getObject(i).toString());
                 }catch (SQLException ref){
        System.out.println(ref.getMessage());}

                try{  
        System.out.println("\n********getColumnName()**********\n");
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
            System.out.println("\t" + resultMeta.getColumnName(i).toUpperCase());
         }catch (SQLException ref){
        System.out.println(ref.getMessage());}
   
                // TEST
         
     long id;
    String lastName;
    String firstName;
    String eMail;
    String userName;
    String password;
    String postIt;
    ArrayList<Address> billingAddress;
    
      /*        
           Customer alpha = new Customer();
      try {
          result = state.executeQuery("SELECT CUSTOMER_L_NAME from CUSTOMER");
      } catch (SQLException ex) {
          Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
      }*/
       
                
    }
       
           
}
