
package content_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.util.*;

public class resetPass extends JFrame implements ActionListener {
    
    JButton reset,forget;
    JTextField oldText , newText;

    resetPass(){
        setLayout(null);
        
        JLabel formno = new JLabel(" Reset Password "  );
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(270, 20, 600, 40);
        add(formno);
        
        JLabel oldpass = new JLabel(" enter old-password: " );
        oldpass.setFont(new Font("Raleway",Font.BOLD,20));
        oldpass.setBounds(100, 140, 250, 30);
        add(oldpass);
        
        oldText = new JTextField();
        oldText.setFont(new Font("Raleway",Font.BOLD,14));
        oldText.setBounds(320,140,400,30);
        add(oldText);
        
        JLabel newpass = new JLabel(" enter new-password: " );
        newpass.setFont(new Font("Raleway",Font.BOLD,20));
        newpass.setBounds(100, 190, 250, 30);
        add(newpass);
        
        newText = new JTextField();
        newText.setFont(new Font("Raleway",Font.BOLD,14));
        newText.setBounds(320,190,400,30);
        add(newText);
        
        reset = new JButton("reset");
        reset.setBounds(200,400,100,20);
        reset.addActionListener(this);
        add(reset);
        
        forget = new JButton("forget password?");
        forget.setBounds(400,400,150,20);
        forget.addActionListener(this);
        add(forget);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== reset){
          
           
           String oldtext = oldText.getText();
           String newtext = newText.getText();
            
            Dbfunctions db = new Dbfunctions();
            Connection conn = db.connect_to_db();
 
            Statement statement;
        try{
            String query = "update login set password = '"+newtext+"' where password ='"+oldtext+"' ";
            String query2 = "select * from login where password = '"+oldtext+"';";
            statement = conn.createStatement();
            ResultSet rs =statement.executeQuery(query2);
            if(rs.next()){
                 JOptionPane.showMessageDialog(null, "password reset");
                 statement.executeUpdate(query);
            }else{
                JOptionPane.showMessageDialog(null, "wrong old password");
            }
            //statement.executeUpdate(query);
            
            System.out.println("row created , login updated");
        }catch(Exception e){
            System.out.println(e);
        }
            setVisible(false);
            new Login().setVisible(true);
        }
       else if(ae.getSource()== forget){
            setVisible(false);
            new forgetPass().setVisible(true);
        }
        
    }
    
    public static void main(String args[]) {
        
        new resetPass();
       
    }
}
