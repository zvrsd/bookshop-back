///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package loic;
//
//import static bookshop.BDD.result;
//import static bookshop.BDD.state;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author Loïc
// */
//public class ShippingOfferDAO {
//    
//    //
//    
//    
//    public ShippingOffer getShippingById(int id) throws SQLException {
//        
//        connection = DriverManager.getConnection(url, username, password); 
//         query = "SELECT * from SHIPPING_OFFER where SHIPPING_OFFER_ID = '"+ id +"'";
//         state = connection.createStatement();
//        
//        connection.createStatement();
//        result = state.executeQuery(query); 
//      
//        
//        if (result.next()){
//        
//        sO = new ShippingOffer(result.getLong("SHIPPING_OFFER_ID"), result.getString("SHIPPING_OFFER_NAME"), result.getString("SHIPPING_OFFER_CONDITIONS")
//              ,result.getDouble("SHIPPING_OFFER_HT_PRICE"));
//        
//        }else {
//            JOptionPane.showMessageDialog(new JFrame(), "Transporteur inexistant");
//        }
//        return sO;
//        
//      
//  }
//    
//
//
//    
//}
