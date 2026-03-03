import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//     To run the code    javac -cp ".;libs\mysql-connector-j-9.5.0.jar" JDBC_demo.java
public class JDBC_demo extends JFrame implements ActionListener {

    // Components
    JLabel lblId, lblName, lblEmail;
    JTextField txtId, txtName, txtEmail;
    JButton btnInsert, btnUpdate, btnDelete;

    // Database connection
    Connection con;

    JDBC_demo() {
        setTitle("JDBC Swing CRUD Example");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels
        lblId = new JLabel("ID:");
        lblName = new JLabel("Name:");
        lblEmail = new JLabel("Email:");

        // TextFields
        txtId = new JTextField();
        txtName = new JTextField();
        txtEmail = new JTextField();

        // Buttons
        btnInsert = new JButton("Insert");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        // Add components
        add(lblId); add(txtId);
        add(lblName); add(txtName);
        add(lblEmail); add(txtEmail);
        add(btnInsert); add(btnUpdate); add(btnDelete);

        // Add ActionListener
        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);

        // Connect to Database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC Driver
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:4040/testdb", "root", "root"); // change username/password
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "DB Connection Failed: " + e.getMessage());
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String email = txtEmail.getText();

        try {
            PreparedStatement ps;

            if (e.getSource() == btnInsert) {
                ps = con.prepareStatement("INSERT INTO students (id, name, email) VALUES (?, ?, ?)");
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, email);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Inserted");

            } else if (e.getSource() == btnUpdate) {
                ps = con.prepareStatement("UPDATE students SET name=?, email=? WHERE id=?");
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setInt(3, id);
                int rows = ps.executeUpdate();
                if (rows > 0)
                    JOptionPane.showMessageDialog(this, "Record Updated");
                else
                    JOptionPane.showMessageDialog(this, "ID not found");

            } else if (e.getSource() == btnDelete) {
                ps = con.prepareStatement("DELETE FROM students WHERE id=?");
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                if (rows > 0)
                    JOptionPane.showMessageDialog(this, "Record Deleted");
                else
                    JOptionPane.showMessageDialog(this, "ID not found");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new JDBC_demo();
    }
}
