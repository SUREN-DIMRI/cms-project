
package content_management_system;

import java.sql.*;

public class conn {
    
    Connection c;
    Statement s;
    public conn(){
        try{
            c = DriverManager.getConnection("jdbc:postgresql:///cms" , "postgre" ,"root");
            s = c.createStatement();
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
