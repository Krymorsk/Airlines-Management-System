package AirlinesManagementSystem;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class FlightZone extends JFrame
{
    private JTable table;
    Choice ch1;
    
    public static void main(String[] args)
    {		 
	new FlightZone().setVisible(true);    
    }
    
    public FlightZone()
    {
        getContentPane().setBackground(new java.awt.Color(77, 157, 227));
        getContentPane().setFont(new Font("Arial",Font.BOLD,18));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel flightCode = new JLabel("Flight Code");
	flightCode.setFont(new Font("Arial",Font.BOLD,18));
        flightCode.setBounds(100, 100, 150, 30);
        flightCode.setForeground(new Color(15, 11, 1));
	add(flightCode);
	
		
	JLabel FlightDetails = new JLabel("Air India Flight Information");
	FlightDetails.setFont(new Font("Arial",Font.BOLD,33));
	FlightDetails.setForeground(new Color(15, 11, 1));
	FlightDetails.setBounds(250, 20, 570, 35);
	add(FlightDetails);
		
	JButton bt = new JButton("Show Details");
	bt.setFont(new Font("Arial",Font.BOLD,20));
	
        bt.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae)
            {
                
                try 
                {
                    String code = ch1.getSelectedItem();
                    ConnectionClass c = new ConnectionClass();
                    String str = "select * from flight where f_code = '"+code+"'";
                    ResultSet rs = c.stm.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        });
        bt.setBounds(560, 100, 220, 30);
	add(bt);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        table.setFont(new Font("Arial",Font.BOLD,14));
        add(table);
//        JScrollPane pane = new JScrollPane(table);
//	pane.setBounds(23, 250, 800, 300);
//        pane.setBackground(Color.WHITE);
//        add(pane);
	
        ch1=new Choice();
        ch1.setBounds(290, 103, 200, 35);
        ch1.setFont(new Font("Arial",Font.BOLD,18));
        try
        {
            ConnectionClass con = new ConnectionClass();
            String str = "select distinct f_code from flight";
            ResultSet rs = con.stm.executeQuery(str);
            while(rs.next())
            {
               ch1.add(rs.getString("f_code"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
	add(ch1);
		
	JLabel FlightCode = new JLabel("Flight Code");
	FlightCode.setFont(new Font("Arial",Font.BOLD,14));
        FlightCode.setForeground(new Color(15, 11, 1));
        FlightCode.setBounds(33, 220, 126, 16);
	add(FlightCode);
		
	JLabel FlightName = new JLabel("Flight Name");
        FlightName.setFont(new Font("Arial",Font.BOLD,14));
        FlightName.setForeground(new Color(15, 11, 1));
	FlightName.setBounds(155, 220, 120, 16);
	add(FlightName);
		
	JLabel Source = new JLabel("Source");
	Source.setFont(new Font("Arial",Font.BOLD,14));
        Source.setForeground(new Color(15, 11, 1));
	Source.setBounds(275, 220, 104, 16);
	add(Source);
		
	JLabel Destination = new JLabel("Destination");
	Destination.setFont(new Font("Arial",Font.BOLD,14));
        Destination.setForeground(new Color(15, 11, 1));
	Destination.setBounds(380, 220, 120, 16);
	add(Destination);
		
		
	JLabel Capacity = new JLabel("Capacity");
	Capacity.setFont(new Font("Arial",Font.BOLD,14));
        Capacity.setForeground(new Color(15, 11, 1));
	Capacity.setBounds(497, 220, 111, 16);
	add(Capacity);
		
	JLabel ClassName = new JLabel("Class Name");
	ClassName.setFont(new Font("Arial",Font.BOLD,14));
        ClassName.setForeground(new Color(15, 11, 1));
	ClassName.setBounds(610, 220, 120, 16);
	add(ClassName);
		
	JLabel Price = new JLabel("Price");
	Price.setFont(new Font("Arial",Font.BOLD,14));
        Price.setForeground(new Color(15, 11, 1));
	Price.setBounds(740, 220, 111, 16);
	add(Price);
		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(100,50);
		
    }
}