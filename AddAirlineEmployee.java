package AirlinesManagementSystem;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AddAirlineEmployee extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3;
    JPasswordField pf;
    Font f,f1;
    
    AddAirlineEmployee()
    {
        super("Add Airlines Employee");
        setLocation(450,50);
        setSize(450,350);
        
        f=new Font("Arial",Font.BOLD,20);
        f1=new Font("Arial",Font.BOLD,15);
        
        l1=new JLabel("Add Airlines Employee");
        l2=new JLabel("Username");
        l3=new JLabel("Employee Name");
        l4=new JLabel("Password");
        l5=new JLabel("Phone");
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        pf=new JPasswordField();
        
              
        bt1=new JButton("Add Employee");
        bt2=new JButton("Back");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        pf.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(5,2,10,10));
        
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(pf);
        p2.add(l5);
        p2.add(tf3);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
    }
    public void actionPerformed(ActionEvent e)
    {
        String usn=tf1.getText();
        String name=tf2.getText();
        String phone=tf3.getText();
        String password=pf.getText();
        
        if(e.getSource()==bt1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="insert into signup(username,name,password,phone) values('"+usn+"','"+name+"','"+password+"','"+phone+"')";
                int aa=obj.stm.executeUpdate(q);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "your data successfully Inserted");
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Plese!, Fill all details carefully");
                }
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
            new AdminHomePage().setVisible(true);
        }
    }
    public static void main(String[] args) 
    {
        new AddAirlineEmployee().setVisible(true);
    }
}