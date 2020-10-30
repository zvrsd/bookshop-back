/*
 * THIS IS JUNK CODE!!!!!
 * THIS IS JUNK CODE!!!!!
 * THIS IS JUNK CODE!!!!!
 * THIS IS JUNK CODE!!!!!
 * THIS IS JUNK CODE!!!!!
 */
package com.nope.bookshop.login;

/**
 *
 * @author Cy
 */
public class Junk {
 /** HERE IS THE OK BUTTON ACTION!!!
     * 
     * 
     *  Skllz to get and compare login + dates.
     * 
     * 
     *   String user = "SELECT `EMPLOYEE_LOGIN`, FROM"
     *           + "`EMPLOYEE` WHERE `EMPLOYEE_LOGIN` = ?";
     *   String pass = "SELECT `EMPLOYEE_PASSWORD` FROM `EMPLOYEE` WHERE"
     *           +"`EMPLOYEE_LOGIN` = "+user+" AND `EMPLOYEE_PASSWORD` = ?";
     *   String dateEnd = "SELECT 'EMPLOYEE_DATE_END' FROM `EMPLOYEE` WHERE"
     *           +"`EMPLOYEE_LOGIN` = "+user;
     *   String dateStart = "SELECT 'EMPLOYEE_DATE_START' FROM `EMPLOYEE` WHERE"
     *           +"`EMPLOYEE_LOGIN` = "+user;
     * 
     * IF statement to check date.
     * 
     * 
     * 
     */
        
//          Connection connexion= null;
//        try {
//            SQLServerDataSource ds = new SQLServerDataSource();
//            ds.setUser("sa");
//            ds.setPassword("sa");
//            ds.setServerName("localhost");
//            ds.setPortNumber(1433);
//            ds.setDatabaseName("BookShop");
//            connexion= ds.getConnection();
//        } catch (SQLServerException ex) {
//            System.err.println("Oops:connexion:"+ ex.getMessage());
//        }
//    DBConnection dbConn = new DBConnection();
//        Statement st = dbConn.createStatement();
//        
//        
//        String sql = 
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        try{
//                pst = connexion.prepareStatement(sql)
//                
//        } catch (SQLException ex) {
//            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
//        }
//{
//                  String query= "SELECT EMPLOYEE_LOGIN "
//                          +"EMPLOYEE_PASSWORD FROM EMPLOYEE WHERE "
//                          +"EMPLOYEE_LOGIN = ? AND EMPLOYEE_PASSWORD = ?";
//                  
//            try {      rs = pst.executeQuery(query);
//            } catch (SQLException ex) {
//                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                  
//              try {
//                  if ( rs.next()) {
//                      JOptionPane.showMessageDialog(null, "Login Success.");
//                      dispose();
//                      /**
//                       * System.out.println( rs.getInt("EMPLOYEE_ID"));
//                       * System.out.println( rs.getString("EMPLOYEE_LOGIN"));
//                       * System.out.println( rs.getString("EMPLOYEE_PASSWORD"));
//                       *  System.out.println("--");
//                       * }
//                       * System.out.println("******");
//                       *
//                       * while( rs.previous()) {
//                       * System.out.println( rs.getString("EMPLOYEE_ID"));
//                       * System.out.println( rs.getString("EMPLOYEE_LOGIN"));
//                       * System.out.println( rs.getString("EMPLOYEE_PASSWORD"));
//                       * System.out.println("--");
//                       * }
//                       *
//                       */
//                  } else{
//                      JOptionPane.showMessageDialog(null, "Login Failed.");
//                      
//                       rs.close();
//                      }
//                  }
//                catch (SQLException ex) {
//                  Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
//              }
//      
//        }
//        try {
//            connexion.close();
//        } catch (SQLException ex) {
//            System.err.println("Oops:close:"+ ex.getMessage());
//        }
//        System.out.println("Done!");

       
/** THIS METHOD GIVES RED DATABASE ERRORS.
 *
 * 
 * 
 *  String user = Username.getText();
    String pass = Password.getText(); 
     Connection connection;
        PreparedStatement ps;
        
        try {
            connection = DriverManager.getConnection(DB_URL);
            ps = connection.prepareStatement("SELECT `EMPLOYEE_LOGIN`,"
                    +"`EMPLOYEE_PASSWORD` FROM `EMPLOYEE` WHERE"
                    +"`EMPLOYEE_LOGIN` = ? AND `EMPLOYEE_PASSWORD` = ?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Login Success.");
                String[] args = null;
                LoginScreen.main(args);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Login Failed.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
 */    
    

        
            
}
