
package content_management_system;

import javax.swing.*;
import java.awt.*;

public class dashboard extends JFrame {

    dashboard(){
        
        setTitle("Dashboard");
        
        setLayout(null);
        
        // Create a page which consists of a blog at top , then few posts 
        
        JLabel label = new JLabel("DashBoard");
        label.setFont(new Font("Raleway" , Font.BOLD , 38));
        label.setBounds(300,30,400,38); //  ( length from above , length for the left side , length of the label , width of the label )
        add(label);
        
        JLabel content = new JLabel("Your Content");
        content.setFont(new Font("Raleway" , Font.BOLD , 22));
        content.setBounds(350, 200 , 300, 22);
        add(content);
        
        JTextArea tarea = new JTextArea(10,15);
        
        JScrollPane sp = new JScrollPane(tarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(sp);
        
        
        setSize(850,800);
        setLocation(400,100);
        setVisible(true);
        
        
        
    }
    
    public static void main(String args[]) {
       
        new dashboard();
    }
}
