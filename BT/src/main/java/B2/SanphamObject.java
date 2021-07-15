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
public class SanphamObject {
    private int masp;
    private String tensp;
    private String donvitinh;
    private int gia;

    public SanphamObject(int masp, String tensp, String donvitinh, int gia) {
        this.masp = masp;
        this.tensp = tensp;
        this.donvitinh = donvitinh;
        this.gia = gia;
    }

    public SanphamObject() {
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    
}
