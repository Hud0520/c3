/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B2;

/**
 *
 * @author Hud
 */
public class ChitiethoadonObject {
    private int mahd;
    private int masp;
    private int dongia;
    private int soluong;
    private String loaidonhang;

    public ChitiethoadonObject(int mahd, int masp, int dongia, int soluong, String loaidonhang) {
        this.mahd = mahd;
        this.masp = masp;
        this.dongia = dongia;
        this.soluong = soluong;
        this.loaidonhang = loaidonhang;
    }

    public ChitiethoadonObject() {
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getLoaidonhang() {
        return loaidonhang;
    }

    public void setLoaidonhang(String loaidonhang) {
        this.loaidonhang = loaidonhang;
    }
    
    
}
