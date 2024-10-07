
package content_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbfunctions {
    public Connection connect_to_db(){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cms","postgres","root");
            if(conn!=null){
                System.out.println("Connected");
            }
            else{
                  System.out.println("not Connected");
            }
        }catch(Exception e){
             System.out.println(e);
        }
        return conn;
    }
    public void SignupTable(Connection conn){
        Statement statement;
        try{
            String query = "create table signup (name varchar(20),gender varchar(10),dob varchar(10),formno varchar(4));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("table created");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
}


