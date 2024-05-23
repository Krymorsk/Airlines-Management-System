package AirlinesManagementSystem;

import javax.swing.*;
import java.sql.*;

public class ViewCargo {
    JFrame frame;
    JTable table;
    String[] columnNames = {"Cargo ID", "Description", "Weight", "Sender", "Receiver"};
    String[][] data = new String[20][5];
    int i = 0, j = 0;

    ViewCargo() {
        frame = new JFrame("View Cargo");
        frame.setLayout(null);
        frame.setSize(800, 400);
        frame.setLocation(200, 200);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM cargo";
            ResultSet rs = obj.stm.executeQuery(q);

            while (rs.next()) {
                data[i][j++] = rs.getString("cargoId");
                data[i][j++] = rs.getString("description");
                data[i][j++] = rs.getString("weight");
                data[i][j++] = rs.getString("sender");
                data[i][j++] = rs.getString("receiver");
                i++;
                j = 0;
            }

            table = new JTable(data, columnNames);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 20, 750, 300);
        frame.add(sp);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ViewCargo();
    }

    public void setVisible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }
}
