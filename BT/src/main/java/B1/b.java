/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B1;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hud
 */
public class b {
    public boolean addLoaiSP(Connection c,int mlsp, String tlsp){
        String sql = "INSERT INTO loaisanpham VALUES (?,?)";
        try {
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setInt(1, mlsp);
            pre.setString(2, tlsp);
            
            int rs = pre.executeUpdate();
            if(rs == 0){
                return false;
            }else{
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(b.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void main(String[] args) {
        try {
            b test = new b();
            Connect c = new Connect();
            if(test.addLoaiSP(c.getConnection(),3,"Oto Điện")){
                System.out.println("Thành Công");
            }else{
                System.out.println("Không thành công");
            }
        } catch (SQLException ex) {
            Logger.getLogger(b.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
