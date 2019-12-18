
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laurence
 */
public class add_class{
    
    
    public int add(String firstname, String lastname, String username, String password){
        int ad = 0;
        String sql = "INSERT INTO list VALUES(?,?,?,md5(?));";
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/formreg?", "root", "");
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, firstname);
        pstmt.setString(2, lastname);
        pstmt.setString(3, username);
        pstmt.setString(4, password);
        
        pstmt.executeUpdate();
        ad=1;
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(add_class.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ad;
    }
    
    
      public int jcheckpass(String pass, String cpass){
        int i = 0;
        if(pass.equals(cpass)){
            i=1;
        }else{
            i=0;
        }
        
        
        return i;
    }
      
      
      
      public int checkuser(String uname){
        int tl=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/formreg?", "root", "");
            String sql = "select * from list where username=?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uname);
            
            ResultSet rs =pstmt.executeQuery();
            if(rs.next()){
               tl=1;
            }else{
                tl=0;
            }
            
            
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(add_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(add_class.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tl;
        
    }
}
