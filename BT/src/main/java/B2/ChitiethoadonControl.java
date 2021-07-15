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
public class ChitiethoadonControl {
    private Connect c;
    
    public ArrayList<ChitiethoadonObject> getAll(){
        String sql = "SELECT * FROM chitiethoadon";
        ArrayList<ChitiethoadonObject> list= new ArrayList<>();
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            
            ResultSet rs = pre.executeQuery();
            ChitiethoadonObject a = null;
            while(rs.next()){
                a = new ChitiethoadonObject();
                a.setMahd(rs.getInt("mahd"));
                a.setMasp(rs.getInt("masp"));
                a.setDongia(rs.getInt("dongia"));
                a.setSoluong(rs.getInt("soluong"));
                a.setLoaidonhang(rs.getString("loaihoadon"));
                list.add(a);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    } 
    
    private boolean add(ChitiethoadonObject a){
        String sql = "INSERT INTO chitiethoadon "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            pre.setInt(1,a.getMahd());
            pre.setInt(2, a.getMasp());
            pre.setInt(3, a.getDongia());
            pre.setInt(4, a.getSoluong());
            pre.setString(5, a.getLoaidonhang());
            
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
    
    private boolean edit(ChitiethoadonObject a){
        String sql = " UPDATE chitiethoadon "
                + "SET masp=?, dongia=?, soluong=? , loaidonhang=? "
                + "WHERE mahd=?";
        try {
            PreparedStatement pre = c.getConnection().prepareStatement(sql);
            
            pre.setInt(1, a.getMasp());
            pre.setInt(2, a.getDongia());
            pre.setInt(3, a.getSoluong());
            pre.setString(4, a.getLoaidonhang());
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
    
     private boolean del(ChitiethoadonObject a){
        String sql = "DELETE from chitiethoadon"
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
}
