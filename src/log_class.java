
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
public class log_class {
    public int list1(String username, String password){
        int lab = 0;
        String sql="SELECT * FROM list WHERE USERNAME=? AND PASSWORD=md5(?);";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/formreg?", "root", "");
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                lab=1;
            }else{
                lab=0;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(log_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(log_class.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lab;
    }
}
