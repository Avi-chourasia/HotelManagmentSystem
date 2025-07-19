package hotel.managment.system;

 import java.sql.*;
 

public class conn {
    Connection c;
    Statement s;
    
    public conn(){
        try{
            
                Class.forName( "com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root"); 
                s = c.createStatement();    
                 
        }catch(ClassNotFoundException | SQLException e){
               
            e.printStackTrace();
        }
       
    }
    public static void main(String[] args) {
        
        new conn();
        
    }
       
}
