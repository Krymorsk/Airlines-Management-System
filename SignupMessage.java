package AirlinesManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import javax.swing.JFrame;


public class SignupMessage extends JFrame implements ActionListener 
{
    JButton b1;
    JLabel l1;
    Font f, f1, f2;
    TextArea t1;
    String s;
    
    public SignupMessage() 
    {
        super("About Signup");
        setLayout(null);
        JButton b1 = new JButton("Exit");
        add(b1);
        b1.setBounds(180, 430, 120, 20);
        b1.addActionListener(this);
        
        Font f = new Font("RALEWAY", Font.BOLD, 180);
        setFont(f);

        s = "                                    Signup Project          \n  "
                + "\nYou can not signup yourself this project, "
                + "You have to raise a query to Admin for creating username and password. "
                ;

        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 250);

        add(t1);

        Font f1 = new Font("RALEWAY", Font.BOLD, 16);
        t1.setFont(f1);

        Container contentPane = this.getContentPane();
        t1 = new TextArea();

        JLabel l1 = new JLabel("About Signup");
        add(l1);
        l1.setBounds(170, 10, 180, 80);
        l1.setForeground(Color.red);

        Font f2 = new Font("RALEWAY", Font.BOLD, 20);
        l1.setFont(f2);

        setBounds(700, 220, 500, 500);

        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) 
    {
        dispose();
    }
    public static void main(String args[]) 
    {
        new SignupMessage().setVisible(true);
    }
}
