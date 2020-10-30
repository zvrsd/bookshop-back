/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.naming.ldap.LdapName;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Loïc
 */
public class CarrierDAO {
    
    public final String lastId = "SELECT @@IDENTITY as ID";
    final ImageIcon icon = new ImageIcon("icone.png");
    Image image2 = icon.getImage().getScaledInstance(32,32,0);
    
     public void add(String label, String eMail, String lName, String fName, String street, String streetExtra, String postCode, String city, String phone, String phoneExtra) {
        ConnectionDAO connecter = new ConnectionDAO();
        Connection connect = connecter.Connecter();
        
        try {
            //création adresse
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT into ADDRESS (ADDRESS_L_NAME, ADDRESS_F_NAME, ADDRESS_STREET, ADDRESS_STREET_EXTRA, ADDRESS_POSTCODE, ADDRESS_CITY, ADDRESS_PHONE, ADDRESS_PHONE_EXTRA) values (?, ?, ?, ?, ? , ?, ?, ?);");
            preparedStatement.setString(1, lName);
            preparedStatement.setString(2, fName);
            preparedStatement.setString(3,street);
            preparedStatement.setString(4, streetExtra);
            preparedStatement.setString(5, postCode);
            preparedStatement.setString(6, city);
            preparedStatement.setString(7, phone);
            preparedStatement.setString(8, phoneExtra);
            preparedStatement.executeUpdate();
            //récup id adresse
            preparedStatement = connect.prepareStatement(lastId);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            String idAddress = ("");
            while (resultSet.next()) {
                idAddress = resultSet.getString(1);
            }
            //création transport lié
            preparedStatement = connect.prepareStatement("INSERT into CARRIER (ADDRESS_ID, CARRIER_CORPORATE_NAME, CARRIER_EMAIL) values (?, ?, ?);");
            preparedStatement.setString(1, idAddress);
            preparedStatement.setString(2, label);
            preparedStatement.setString(3, eMail);
            
            preparedStatement.executeUpdate();
            
            connect.close();
            preparedStatement.close();
            JOptionPane.showMessageDialog(new JFrame(), "Transport dans Bdd", "Résultat recherche", 1, new ImageIcon(image2));
        } catch (SQLException e) {
            Logger.getLogger(PackageStatusDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
       
        
    }
     
    public List<Carrier> list() {
        
        List<Carrier> carrierList = new ArrayList();
        
        try {
            ConnectionDAO connecter = new ConnectionDAO();
            Connection connect = connecter.Connecter();
            
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT CARRIER_ID, CARRIER_CORPORATE_NAME, CARRIER_EMAIL from CARRIER;");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
            while (resultSet.next()) {
                
                Long id = resultSet.getLong(1);
                String label = resultSet.getString(2);
                String eMail = resultSet.getString(3);
                Carrier carrier = new Carrier(id, label, eMail);
                System.out.println(carrier.getId());
                System.out.println(carrier.getLabel());
                System.out.println(carrier.geteMail());
                carrierList.add(carrier);
                
                               
            }
            connect.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return carrierList;
    }
    
   
    
}
