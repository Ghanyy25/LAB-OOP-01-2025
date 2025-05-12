package main;

import java.time.LocalDate;
// import java.time.*;
import blueprint.Kendaraan;
import interfaces.*;

public class Motor extends Kendaraan implements Bergerak,IServiceable{
    String jenismotor;
    double kapasitastangki;
    String tipesuspensi;
    double speed;//+
    boolean gerak;//+
    LocalDate date ;//+
    boolean rusak = true;//+

    public Motor(String merek, String model){
        super(merek, model);
    }

    @Override
    public double hitungPajak() {
        double pajakDasar = 500000;
        int umur = 2025 - getTahunProduksi(); 
        double diskon = umur * 0.05 * pajakDasar;
        return pajakDasar - Math.min(diskon, pajakDasar * 0.5); 
    }
    @Override
    public String getTipe() {
        return "Motor";
    }

    @Override
    public boolean mulai() {
        return gerak = true;
    }
    @Override
    public boolean berhenti() {
        return gerak = false;
    }
    @Override
    public void setkecepatan(double kecepatan) {
        this.speed = kecepatan;
    }
    @Override
    public double getkecepatan() {
        return speed;
    }

    @Override
    public boolean periksakondisi() {
        return rusak;
    }
    @Override
    public LocalDate getWaktuservisberikutnya() {
        return date =  LocalDate.now().plusMonths(12);
    }
    @Override
    public void lakukanservis() {
        System.out.println(getTipe() + "sudah di servis");
        this.rusak = false;
    }
    @Override
    public double biayaservis() {
        return 100000;
    }

    public void setJenismotor(String jenis) {
        this.jenismotor = jenis;
    }
    public String setJenismotor() {
        return jenismotor;
    }
    public void setTipesuspensi(String tipesuspensi) {
        this.tipesuspensi = tipesuspensi;
    }
    public String getTipesuspensi() {
        return tipesuspensi;
    }
    public void setKapasitastangki(double kapasitastangki) {
        this.kapasitastangki = kapasitastangki;
    }
    public double getKapasitastangki() {
        return kapasitastangki;
    }

}
