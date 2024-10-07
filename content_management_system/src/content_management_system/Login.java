
package content_management_system;

import java.sql.Connection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JButton signin,signup,clear , resetpass;
    JTextField IDText;
    JPasswordField PassText;
    
    Login(){
        
        setTitle("Content Login Page");
        
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.PNG"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome To Login Page");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200, 40, 450, 45);
        add(text);
        
        JLabel ID = new JLabel("User ID");
        ID.setFont(new Font("Osward",Font.BOLD,28));
        ID.setBounds(120, 150, 150, 50);
        add(ID);
        
        IDText = new JTextField();
        IDText.setBounds(300,150,250,50);
        add(IDText);
        
        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Osward",Font.BOLD,28));
        pass.setBounds(120, 220, 250, 50);
        add(pass);
        
        PassText = new JPasswordField();
        PassText.setBounds(300,220,250,50);
        add(PassText);
        
        signin = new JButton("Sign In");
        signin.setBounds(300, 300, 100, 30);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("Sign Up");
        signup.setBounds(300, 350, 230, 30);
        signup.addActionListener(this);
        add(signup);
        
        resetpass = new JButton("reset/forget password");
        resetpass.setBounds(300, 400, 230, 30);
        resetpass.addActionListener(this);
        add(resetpass);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            IDText.setText("");
            PassText.setText("");
        }
        else if(ae.getSource() == signin){
            
            Dbfunctions db = new Dbfunctions();
            Connection conn = db.connect_to_db();
            
            String id = IDText.getText();
            String password = PassText.getText();
            
            Statement statement;
        try{
            String query = "select * from login where ID = '"+id+"' and password = '"+password+"' ";
            String query2 = "";
            
            statement = conn.createStatement();
            ResultSet rs =statement.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new dashboard().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "wrong ID or password");
            }
            statement.executeUpdate(query2);
            System.out.println("row created , login updated");
        }catch(Exception e){
            System.out.println(e);
        }

            
            JOptionPane.showMessageDialog(null, "sign-in pressed");
            
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new Signup().setVisible(true);
        }
        else if(ae.getSource() == resetpass){
            setVisible(false);
            new resetPass().setVisible(true);
        }
       
    }
    
    public static void main(String args[]) {
        
        new Login();
        
        
    }

}
