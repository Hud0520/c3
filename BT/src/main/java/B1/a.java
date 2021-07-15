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
public class a {
    public static void main(String[] args) {
        try {
            Connect c = new Connect();
            
            String sql = "SELECT MaSP, TenSP, TenLoaiSP "
                    + "FROM sanpham INNER JOIN loaisanpham on sanpham.MaLoaiSP = loaisanpham.MaLoaiSP";
            
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            
            if(rs!= null){
                while(rs.next()){
                    System.out.print(rs.getInt("MaSP")+"\t");
                    System.out.print(rs.getString("TenSP")+"\t");
                    System.out.print(rs.getString("TenLoaiSP")+"\n");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
