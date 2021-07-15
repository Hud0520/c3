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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hud
 */
public class NhanVienControl {
    private Connect c;
    
    
    public ArrayList<NhanvienObject> getAll(){
        String sql = "SELECT * FROM nhanvien";
        ArrayList<NhanvienObject> list= new ArrayList<>();
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            
            ResultSet rs = pre.executeQuery();
            NhanvienObject a = null;
            while(rs.next()){
                a = new NhanvienObject();
                a.setManv(rs.getInt("manv"));
                a.setHoten(rs.getString("hoten"));
                a.setDiachi(rs.getString("diachi"));
                a.setNgaysinh(rs.getString("ngaysinh"));
                a.setDienthoai(rs.getString("dienthoai"));
                a.setGioitinh(rs.getString("gioitinh"));
                list.add(a);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    } 
    
    private boolean add(NhanvienObject a){
        String sql = "INSERT INTO nhanvien "
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            pre.setInt(1,a.getManv());
            pre.setString(2, a.getHoten());
            pre.setString(3, a.getNgaysinh());
            pre.setString(4, a.getDiachi());
            pre.setString(5, a.getDienthoai());
            pre.setString(6, a.getNgaysinh());
            
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
    
    private boolean edit(NhanvienObject a){
        String sql = " UPDATE nhanvien "
                + "SET hoten=?, ngaysinh=?, diachi=?, dienthoai=? , ngaysinh=? "
                + "WHERE manv = ?";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            
            pre.setString(1, a.getHoten());
            pre.setString(2, a.getNgaysinh());
            pre.setString(3, a.getDiachi());
            pre.setString(4, a.getDienthoai());
            pre.setString(5, a.getNgaysinh());
            pre.setInt(6,a.getManv());
            
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
    
     private boolean del(NhanvienObject a){
        String sql = "DELETE from nhanvien"
                + " WHERE manv = ?";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            pre.setInt(1,a.getManv());
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
