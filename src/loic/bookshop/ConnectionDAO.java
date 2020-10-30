
package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Loïc
 */
public class ConnectionDAO {
    
    
    public Connection Connecter() {
         String connectionUrl = "jdbc:sqlserver://localhost:1433;"
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
        return connect;
        
    }
    
}
