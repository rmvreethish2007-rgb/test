import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StudentCRUDMySQLNew extends JFrame{
    JTextField txtid,txtname,txtcourse;
    JButton btninsert ,btnupdate,btndelete,btnclear;
    
    Connection con;
    PreparedStatement ps;
    
    public StudentCRUDMySQLNew(){
        setTitle("CRUD");
        setSize(450,300);
        setLayout(new GridLayout(5,2,10,10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new JLabel("student id"));
        txtid=new JTextField();add(txtid);
        
        add(new JLabel("student name"));
        txtname=new JTextField();add(txtname);
        
        add(new JLabel("student course"));
        txtcourse=new JTextField();add(txtcourse);
        
        btninsert = new JButton("insert");add(btninsert);
        btnupdate = new JButton("update");add(btnupdate);
        btndelete = new JButton("delete");add(btndelete);
        btnclear = new JButton("clear");add(btnclear);
     
        connectMySQL();
        
        btninsert.addActionListener(e -> insertRecord());
        btnupdate.addActionListener(e -> updateRecord());
        btndelete.addActionListener(e -> deleteRecord());
        btnclear.addActionListener(e -> clearRecord());
        
    }
    void connectMySQL(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/studentdb","root","admin");
            JOptionPane.showMessageDialog(this,"Connection successful");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"db error:"+ e.getMessage());
        }
        
    }
    
    void insertRecord(){
        try{
            ps=con.prepareStatement("Insert into student_record (id,name,course) values(?,?,?)");
            ps.setInt(1,Integer.parseInt(txtid.getText()));
            ps.setString(2,(txtname.getText()));
            ps.setString(3,(txtcourse.getText()));
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Inserted");
            clearRecord();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"db error:"+ e.getMessage());
        }
        
    }
    
    void updateRecord(){
        try{
            ps=con.prepareStatement("Update  student_record set name=?,course=? where id=? ");
            
            ps.setString(1,(txtname.getText()));
            ps.setString(2,(txtcourse.getText()));
            ps.setInt(3,Integer.parseInt(txtid.getText()));
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"updated");
             clearRecord();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"db error:"+ e.getMessage());
        }
        
    }
    
    void deleteRecord(){
        try{
            ps=con.prepareStatement("Delete from student_record where id=? ");      
            ps.setInt(1,Integer.parseInt(txtid.getText()));        
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Deleted");
             clearRecord();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"db error:"+ e.getMessage());
        }
        
    }
    
    void clearRecord(){
        txtid.setText("");
        txtname.setText("");
         txtcourse.setText("");
    }
    
    public static void main(String[] args){
        new StudentCRUDMySQLNew().setVisible(true);   
    }   
}
