
package content_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class postconn {
   // public static void main(String[] args) {
    
    postconn(){
        String url = "jdbc:postgresql://localhost:5432/cms";
        String user = "postgres";
        String password = "root";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL!");
            
            

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    //}
}
