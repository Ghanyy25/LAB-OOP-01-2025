package main;

import java.time.LocalDate;
// import java.time.*;
import blueprint.Kendaraan;
import interfaces.*;

public class Sepeda extends Kendaraan implements Bergerak,IServiceable{
    String jenissepeda;
    int ukuranroda;
    int jumlahgear;
    double speed;//+
    // boolean gerak;//+
    LocalDate date ;//+
    boolean rusak = true;//+

    public Sepeda(String merek, String model){
        super(merek, model);
    }

    @Override
    public double hitungPajak() {
        double pajakDasar = 50000;
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
        return 25000;
    }

    public void setJenissepeda(String jenis) {
        this.jenissepeda = jenis;
    }
    public String setJenissepeda() {
        return jenissepeda;
    }
    public void setUkuranroda(int ukuranroda) {
        this.ukuranroda = ukuranroda;
    }
    public int getUkuranroda() {
        return ukuranroda;
    }
    public void setJumlahgear(int ukuranroda) {
        this.jumlahgear = ukuranroda;
    }
    public int getJumlahgear() {
        return jumlahgear;
    }
        

}
