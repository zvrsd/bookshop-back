
package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Loïc
 */
public class PackageStatusDAO {
    
    
    public void add(String label) {
        ConnectionDAO connecter = new ConnectionDAO();
        Connection connect = connecter.Connecter();
        
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT into PACKAGE_STATUS (PACKAGE_STATUS_NAME) values (?);");
            preparedStatement.setString(1, label);
            preparedStatement.executeUpdate();
            connect.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PackageStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
    
    public void alter(Long id, String label) {
        ConnectionDAO connecter = new ConnectionDAO();
        Connection connect = connecter.Connecter();
        
        try {
            
            PreparedStatement preparedStatement = connect.prepareStatement("UPDATE PACKAGE_STATUS SET PACKAGE_STATUS_NAME = ? WHERE PACKAGE_STATUS_ID =?;");
            preparedStatement.setString(1, label);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            connect.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PackageStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<PackageStatus> list() {
        
         List<PackageStatus> listPackageStatus = new ArrayList();
         
        try {
            ConnectionDAO connecter = new ConnectionDAO();
            Connection connect = connecter.Connecter();
            
            
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT * from PACKAGE_STATUS;");
            ResultSet resultSet = preparedStatement.executeQuery();

            
            
            while (resultSet.next()) {
                
                Long id = resultSet.getLong(1);
                String label = resultSet.getString(2);
                PackageStatus packageStatus = new PackageStatus(id, label);
                System.out.println(packageStatus.getId());
                System.out.println(packageStatus.getLabel());
                
                listPackageStatus.add(packageStatus);
                
                               
            }
            connect.close();
            preparedStatement.close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PackageStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       return listPackageStatus;
        
             
    }
    

    
}
