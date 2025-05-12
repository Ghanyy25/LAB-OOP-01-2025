package main;

import java.time.*;

import blueprint.Kendaraan;
import interfaces.*;


public class Mobil extends Kendaraan implements Bergerak,IServiceable{
    int jumlahpintu;
    int jumlahkursi;
    double kapasitasmesin;
    String bahanbakar;
    double speed;//+
    boolean gerak;//+
    LocalDate date ;//+
    boolean rusak = true;//+

    public Mobil(String merek, String model){
        super(merek, model);
    }

    @Override
    public double hitungPajak() {
        double pajakDasar = 1000000;
        int umur = 2025 - getTahunProduksi(); 
        double diskon = umur * 0.05 * pajakDasar;
        return pajakDasar - Math.min(diskon, pajakDasar * 0.5); 
    }
    @Override
    public String getTipe() {
        return "Mobil";
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
        return 200000;
    }



    public void setJumlahpintu(int jumlahpintu) {
        this.jumlahpintu = jumlahpintu;
    }
    public int getJumlahpintu() {
        return jumlahpintu;
    }
    public void setBahanbakar(String bahanbakar) {
        this.bahanbakar = bahanbakar;
    }
    public String getBahanbakar() {
        return bahanbakar;
    }
    public void setJumlahkursi(int jumlahkursi) {
        this.jumlahkursi = jumlahkursi;
    }
    public int getJumlahkursi() {
        return jumlahkursi;
    }
    public void setKapasitasmesin(double kapasitasmesin) {
        this.kapasitasmesin = kapasitasmesin;
    }public double getKapasitasmesin() {
        return kapasitasmesin;
    }

}
