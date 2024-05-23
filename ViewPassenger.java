package AirlinesManagementSystem;

import java.awt.*;
import javax.swing.*;

import java.sql.*;

public class ViewPassenger extends JFrame
{
    JTable t;
    JButton bt1;
    JTextField tf1;
    JPanel p1,p2,p3;
    String x[]={"Username","Name","Age","Date of birth","Address","Phone","Email","Nationality","Gender","Passport Number"};
    String y[][]=new String [20][10];
    int i=0,j=0;
    Font f,f1;
    JLabel l1,l2;

    ViewPassenger()
    {       
        super("All Passenger records");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic",Font.BOLD,17);
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select * from passenger";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("age");
                y[i][j++]=rest.getString("dob");
                y[i][j++]=rest.getString("address");
                y[i][j++]=rest.getString("phone");
                y[i][j++]=rest.getString("Email");
                y[i][j++]=rest.getString("nationality");
                y[i][j++]=rest.getString("gender");
                y[i][j++]=rest.getString("passport");
                i++;
                j=0;
            }
            t=new JTable(y,x);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        
        JScrollPane js=new JScrollPane(t);
        add(js);
    }
    public static void main(String args[])
    {
        new ViewPassenger().setVisible(true);
    }
}
