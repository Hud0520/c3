/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hud
 */
public class SanphamControl {
    private Connect c;
    
    public ArrayList<SanphamObject> getAll(){
        String sql = "SELECT * FROM sanpham";
        ArrayList<SanphamObject> list= new ArrayList<>();
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            
            ResultSet rs = pre.executeQuery();
            SanphamObject a = null;
            while(rs.next()){
                a = new SanphamObject();
                a.setMasp(rs.getInt("masp"));
                a.setTensp(rs.getString("tensp"));
                a.setDonvitinh(rs.getString("donvitinh"));
                a.setGia(rs.getInt("gia"));
                
                list.add(a);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    } 
    
    private boolean add(SanphamObject a){
        String sql = "INSERT INTO sanpham "
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            pre.setInt(1,a.getMasp());
            pre.setString(2, a.getTensp());
            pre.setString(3, a.getDonvitinh());
            pre.setInt(4, a.getGia());
            
            int rs = pre.executeUpdate();
            if(rs == 0){
                return false;
            }else{
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    private boolean edit(SanphamObject a){
        String sql = " UPDATE sanpham "
                + "SET tensp=?, donvitinh=? , gia=? "
                + "WHERE masp=?";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            
            pre.setInt(4,a.getMasp());
            pre.setString(1, a.getTensp());
            pre.setString(2, a.getDonvitinh());
            pre.setInt(3, a.getGia());
            int rs = pre.executeUpdate();
            if(rs == 0){
                return false;
            }else{
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
     private boolean del(SanphamObject a){
        String sql = "DELETE from hoadon"
                + " WHERE masp = ?";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            pre.setInt(1,a.getMasp());
            int rs = pre.executeUpdate();
            if(rs == 0){
                return false;
            }else{
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
