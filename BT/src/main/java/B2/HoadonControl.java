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
public class HoadonControl {
    private Connect c = new Connect();
    
    public ArrayList<HoadonObject> getAll(){
        String sql = "SELECT * FROM hoadon";
        ArrayList<HoadonObject> list= new ArrayList<>();
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            
            ResultSet rs = pre.executeQuery();
            HoadonObject a = null;
            while(rs.next()){
                a = new HoadonObject();
                a.setMahd(rs.getInt("mahd"));
                a.setManv(rs.getInt("manv"));
                a.setNgaylap(rs.getString("ngaylap"));
                a.setNgaynhan(rs.getString("ngaynhan"));
                a.setDiengiai(rs.getString("diengiai"));
                list.add(a);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    } 
    
    private boolean add(HoadonObject a){
        String sql = "INSERT INTO hoadon "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            pre.setInt(1,a.getMahd());
            pre.setInt(2, a.getManv());
            pre.setString(3, a.getNgaylap());
            pre.setString(4, a.getNgaynhan());
            pre.setString(5, a.getDiengiai());
            
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
    
    private boolean edit(HoadonObject a){
        String sql = " UPDATE hoadon "
                + "SET manv=?, ngaylap=?, ngaynhan=? , diengiai=? "
                + "WHERE mahd=?";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            
            pre.setInt(1, a.getManv());
            pre.setString(2, a.getNgaylap());
            pre.setString(3, a.getNgaynhan());
            pre.setString(4, a.getDiengiai());
            pre.setInt(5, a.getMahd());
            
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
    
     private boolean del(HoadonObject a){
        String sql = "DELETE from hoadon"
                + " WHERE mahd = ?";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            pre.setInt(1,a.getMahd());
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
     
     public static void main(String[] args) {
        HoadonControl hc =new HoadonControl();
        
        HoadonObject h = new HoadonObject(2,2,"21/3/2020","22/3/2020","Khong");
        System.out.println("Thêm hd");
        hc.add(h); 
        ArrayList<HoadonObject> list = hc.getAll();
        for( HoadonObject a : list){
            System.out.println(a);
        }
        
        System.out.println("Sửa hd");
        h.setManv(3);
        hc.edit(h); 
        list = hc.getAll();
        for( HoadonObject a : list){
            System.out.println(a);
        }
        
        System.out.println("Xóa hd");
        h.setMahd(2);
        hc.del(h); 
        list = hc.getAll();
        for( HoadonObject a : list){
            System.out.println(a);
        }
    }
}
