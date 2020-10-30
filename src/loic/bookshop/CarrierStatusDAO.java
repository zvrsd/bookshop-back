
package bookshop;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bookshop.CarrierStatus;


public class CarrierStatusDAO {
    
    //public final String lastId = "SELECT @@IDENTITY as ID";
	final ImageIcon icon = new ImageIcon("icone.png");
    Image image2 = icon.getImage().getScaledInstance(32,32,0);
    
    public void add(String label, String postIt) {
        
        ConnectionDAO connecter = new ConnectionDAO();
        Connection connect = connecter.Connecter();
        
        
        
        try {
            // création statut (injection SQL)
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT into CARRIER_STATUS (CARRIER_STATUS_NAME, CARRIER_STATUS_POST_IT) values (?, ?);");
            preparedStatement.setString(1, label);
            preparedStatement.setString(2, postIt);
            preparedStatement.executeUpdate();
            
            // récup id créée
           // preparedStatement = connect.prepareStatement(lastId);
            //ResultSet resultSet = preparedStatement.executeQuery();
            connect.close();
            preparedStatement.close();
            JOptionPane.showMessageDialog(new JFrame(), "Statut transport dans Bdd", "Insert", 1, new ImageIcon(image2));   
        } catch (SQLException ex) {
            Logger.getLogger(PackageStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alter(Long id, String label, String postIt) {
        
        ConnectionDAO connecter = new ConnectionDAO();
        Connection connect = connecter.Connecter();
        
        try {
            
            PreparedStatement preparedStatement = connect.prepareStatement("UPDATE CARRIER_STATUS SET CARRIER_STATUS_NAME = ?, CARRIER_STATUS_POST_IT = ? WHERE CARRIER_STATUS_ID =?;");
            preparedStatement.setString(1, label);
            
            preparedStatement.setString(2, postIt);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
            connect.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PackageStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public List<CarrierStatus> list() {
        
         List<CarrierStatus> listCarrierStatus = new ArrayList();
         
        try {
            ConnectionDAO connecter = new ConnectionDAO();
            Connection connect = connecter.Connecter();
            
            
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT * from CARRIER_STATUS;");
            ResultSet resultSet = preparedStatement.executeQuery();

            
            while (resultSet.next()) {
                
                Long id = resultSet.getLong(1);
                String label = resultSet.getString(2);
                String postIt = resultSet.getString(3);
                CarrierStatus carrierStatus = new CarrierStatus(id, label, postIt);
                System.out.println(carrierStatus.getId());
                System.out.println(carrierStatus.getLabel());
                System.out.println(carrierStatus.getPostIt());
                
                listCarrierStatus.add(carrierStatus);
                
                               
            }
            connect.close();
            preparedStatement.close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CarrierStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       return listCarrierStatus;
        
    }
    
    
    
}
