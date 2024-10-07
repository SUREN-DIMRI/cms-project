
package content_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.util.*;

public class forgetPass extends JFrame implements ActionListener{
    
    JButton done;
    JTextField idText , dobText , newpass;
    forgetPass(){
        setLayout(null);
        
        JLabel text = new JLabel("Forget Password");
        text.setFont(new Font("Raleway",Font.BOLD,38));
        text.setBounds(270, 20, 600, 40);
        add(text);
        
        JLabel id = new JLabel(" enter ID: " );
        id.setFont(new Font("Raleway",Font.BOLD,20));
        id.setBounds(100, 140, 250, 30);
        add(id);
        
        idText = new JTextField();
        idText.setFont(new Font("Raleway",Font.BOLD,14));
        idText.setBounds(320,140,400,30);
        add(idText);
        
        JLabel birth = new JLabel(" enter DOB: " );
        birth.setFont(new Font("Raleway",Font.BOLD,20));
        birth.setBounds(100, 190, 250, 30);
        add(birth);
        
        dobText = new JTextField();
        dobText.setFont(new Font("Raleway",Font.BOLD,14));
        dobText.setBounds(320,190,400,30);
        add(dobText);
        
        
        JLabel resetpass = new JLabel(" enter new-password: " );
        resetpass.setFont(new Font("Raleway",Font.BOLD,20));
        resetpass.setBounds(100, 240, 220, 30);
        add(resetpass);
        
        newpass = new JTextField();
        newpass.setFont(new Font("Raleway",Font.BOLD,14));
        newpass.setBounds(320,240,400,30);
        add(newpass);
        
        done = new JButton("DONE");
        done.setBounds(400,400,100,30);
        done.addActionListener(this);
        add(done);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
        
    }
    
     public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== done){
           JOptionPane.showMessageDialog(null, "password reset");
           
           String idtext = idText.getText();
           String dobtext = dobText.getText();
           String newPass = newpass.getText();
           
            
            Dbfunctions db = new Dbfunctions();
            Connection conn = db.connect_to_db();
 
            Statement statement;
        try{
            String query = "update login set password = '"+newPass+"' where ID ='"+idtext+"' ";
            String query2 = "select * from login where ID = '"+idtext+"';";
            String query3 = "select * from signup where dob = '"+dobtext+"';";
        
            statement = conn.createStatement();
            ResultSet rs =statement.executeQuery(query2);
            ResultSet rs2 =statement.executeQuery(query3);
            if(rs.next()&& rs2.next()){
                 JOptionPane.showMessageDialog(null, "password reset");
                 statement.executeUpdate(query);
            }else{
                JOptionPane.showMessageDialog(null, "wrong old password");
            }
            statement.executeUpdate(query);
            statement.executeUpdate(query2);
            System.out.println("row created , login updated");
        }catch(Exception e){
            System.out.println(e);
        }
           
           
           
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    
    public static void main(String args[]) {
       new forgetPass();
    }
}
