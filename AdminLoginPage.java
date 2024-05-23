package AirlinesManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AdminLoginPage extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    AdminLoginPage()
    {
        
        f=new JFrame("Admin Login");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        f.add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirlinesManagementSystem/Icons/lock3.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(500,240);
        f.setLocation(400,300);
    }

    public void actionPerformed(ActionEvent ee){

        
        if(ee.getSource()==b1)
        {
            try
            {
                String username = t1.getText();
                String password = t2.getText();
                ConnectionClass obj = new ConnectionClass();
                String q = "select * from adminlogin where username='"+username+"' and password='"+password+"'";
                ResultSet rs = obj.stm.executeQuery(q); 
                if(rs.next())
                {
                    new AdminHomePage().setVisible(true);
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    f.setVisible(false);
                    f.setVisible(true);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ee.getSource()==b2)
        {
            this.f.setVisible(false);
        }
    }
    public static void main(String[] args) 
    {
        AdminLoginPage l=new AdminLoginPage();
    }
}
