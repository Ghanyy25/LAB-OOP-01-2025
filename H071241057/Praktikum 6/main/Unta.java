package main;

import java.time.LocalDate;
// import java.time.*;
import blueprint.Kendaraan;
import interfaces.*;

public class Unta extends Kendaraan implements Bergerak{
    String asalunta;
    int beratbawaan;
    String makanan;
    double speed;//+
    // boolean gerak;//+
    LocalDate date ;//+
    // boolean rusak = true;//+..

    public Unta(String merek, String model){
        super(merek, model);
    }

    @Override
    public double hitungPajak() {
        double pajakDasar = 0;
        int umur = 2025 - getTahunProduksi(); 
        double diskon = umur * 0.05 * pajakDasar;
        return pajakDasar - Math.min(diskon, pajakDasar * 0.5); 
    }
    @Override
    public String getTipe() {
        return "Unta";
    }

    @Override
    public boolean mulai() {
        return true;
    }
    @Override
    public boolean berhenti() {
        return true;
    }
    @Override
    public void setkecepatan(double kecepatan) {
        this.speed = kecepatan;
    }
    @Override
    public double getkecepatan() {
        return speed - 0.1*beratbawaan;
    }
    public void setAsalunta(String jenis) {
        this.asalunta = jenis;
    }
    public String getAsalunta(String jenis) {
        return asalunta;
    }
    public void setMakanan(String jumlahgear) {
        this.makanan = jumlahgear;
    }
    public String getMakanan() {
        return makanan;
    }
    public void setBeratbawaan(int beratbawaan) {
        this.beratbawaan = beratbawaan;
    }
    public int getBeratbawaan() {
        return beratbawaan;
    }

}
