/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B2;

import java.util.Scanner;

/**
 *
 * @author Hud
 */
public class HoadonObject {
    private int mahd;
    private int manv;
    private String ngaylap;
    private String ngaynhan;
    private String diengiai;

    public HoadonObject(int mahd, int manv, String ngaylap, String ngaynhan, String diengiai) {
        this.mahd = mahd;
        this.manv = manv;
        this.ngaylap = ngaylap;
        this.ngaynhan = ngaynhan;
        this.diengiai = diengiai;
    }

    public HoadonObject() {
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getNgaynhan() {
        return ngaynhan;
    }

    public void setNgaynhan(String ngaynhan) {
        this.ngaynhan = ngaynhan;
    }

    public String getDiengiai() {
        return diengiai;
    }

    public void setDiengiai(String diengiai) {
        this.diengiai = diengiai;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ma hoa don:");
        this.mahd = sc.nextInt();
        System.out.println("Ma nhan vien:");
        this.manv = sc.nextInt();
        sc.nextLine();
        System.out.println("Ngày Lập:");
        this.ngaylap = sc.next();
        System.out.println("Ngày Nhận:");
        this.ngaynhan = sc.next();
        System.out.println("Diễn giải:");
        this.diengiai = sc.next();
    }

    @Override
    public String toString() {
        return "HoadonObject{" + "mahd=" + mahd + ", manv=" + manv + ", ngaylap=" + ngaylap + ", ngaynhan=" + ngaynhan + ", diengiai=" + diengiai + '}';
    }
    
}
