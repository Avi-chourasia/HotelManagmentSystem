 
package hotel.managment.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 

public class Login  extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JTextField t1;
    JButton b1,b2;
    JPasswordField t2;
    
    Login(){
         
                        l1 = new JLabel("Username");
                        l1.setBounds(40, 20, 100, 20);
                        add(l1);

                        l2 = new JLabel(" Password");
                        l2.setBounds(40, 70, 100, 20);
                        add(l2);

                        t1 = new JTextField();
                        t1.setBounds( 150, 20, 150, 30);
                        add(t1);

                        t2 = new JPasswordField();
                        t2.setBounds( 150,70,150,30);
                        add(t2);

                        b1 = new JButton("Login");
                        b1.setBackground(Color.BLACK);
                        b1.setForeground(Color.WHITE);
                        b1.setBounds( 40,150,120,30);
                        b1.addActionListener(this);
                        add(b1);

                        b2 = new JButton("Cancel");
                        b2.setBounds(180,150,120,30);
                        b2.setBackground(Color.BLACK);
                        b2.setForeground(Color.WHITE);
                        b2.addActionListener(this);
                        add(b2);

                        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icon/second.jpg"));
                        Image i2 = i1.getImage().getScaledInstance( 200, 200, Image.SCALE_DEFAULT);
                        ImageIcon i3 = new ImageIcon(i2);
                        JLabel l3 = new JLabel(i3);
                        l3.setBounds( 350,10,200,200);
                        add(l3);


                        getContentPane().setBackground(Color.WHITE);
                        setLayout(null);
                        setBounds(600, 300,600, 300);
                        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        
           if(ae.getSource()== b1){
                       conn c = new conn();
                       String username = t1.getText().trim();
                       String password = t2.getText().trim();
                       String q ="select * from login Where username='"+username+"' and password='"+password+"'";
                       
                        
               try{   
                        // System.out.println("string"+q);
                         ResultSet rs = c.s.executeQuery(q);
                         
                         
                      if(rs.next()){
                                 String adminName = rs.getString("username");
                                 String adminPassword = rs.getString("password");
                               //  System.out.println("username "+ username + " password" + password);
                                 new DashBoard().setVisible(true);
                                 this.setVisible(false);
                      }
                      else {
                                 JOptionPane.showMessageDialog( null,"Invalid username and password");
                                 this.setVisible(false);
                                 //new HotelManagmentSystem().setVisible(true);
                     }
               }catch(Exception e){
                         System.out.println(" LOGINPANEL Error occurs on Fetching data" +e);
               }     
           }else if (ae.getSource()==b2){
                      
               System.exit(0);
           }
            
    }
    public static void main(String[] args) {
        new Login();
    }
}
