// package F1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    Driver driver = new Driver();
    Car car = new Car();
    String track;
    int tikungan;

    public Race(){
        this.car.merk = "Red Bull Racing RB20";
        this.car.topspeed = 211;
        this.driver.nama = "max verstappen";
        this.driver.handling = 9;
        this.track = "Mandalika";
        this.tikungan = 7;
        System.out.println("Default Max Verstasppen telah dibuat.");
    }
    public Race(String merk, String nama, double handling, int cc, String track, int tikungan){
        this.car.merk = merk;
        this.car.topspeed = Math.max(100, Math.min(cc, 300));
        this.driver.nama = nama;
        this.driver.handling = Math.max(1, Math.min(handling, 10));
        this.track = track;
        this.tikungan = Math.max(5, Math.min(tikungan, 10));
    }

    public double calculateTime(List<TrackSection> trackSections, Race x) {
    double totalTime = 0;
    for (TrackSection i : trackSections) {
        if (i.model.equals("Lurus")) {
            totalTime += i.jarak / (double) x.car.topspeed;
        } else if (i.model.equals("Tikungan")) {
            totalTime += i.jarak / (double)(x.driver.handling * 5);
        }
    }
    return totalTime;
    }

    private List<TrackSection> buatTrack(int kungan){
        List<TrackSection> track = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < kungan; i++) {
            int y = 30 + rand.nextInt(30);
            track.add(new TrackSection("Tikungan", y));

            int x = 70 + rand.nextInt(50);
            track.add(new TrackSection("LURUS", x));
        }
        return track;
    }

    public void start(Race enemy){
        System.out.println("=============BALAPAN DIMULAI DI TRACK "+this.track+"=============");
        List<TrackSection> track = buatTrack(this.tikungan);
        

        System.out.println("Rute :");
        for (TrackSection i : track){
            System.out.println(i.getAll());
        }

        double mytime = calculateTime(track,this);
        double enemytime = calculateTime(track,enemy);
        

        if (mytime < enemytime) {
            System.out.println(this.driver.nama + " memenangkan balapan dengan catatan waktu " + String.format("%.2f", mytime) + " detik");
            System.out.println("sedangkan " + enemy.driver.nama + " kalah, dengan catatan waktu "+ String.format("%.2f", enemytime) + "  detik");
        } else if (enemytime < mytime){
            System.out.println( enemy.driver.nama+ " memenangkan balapan dengan catatan waktu " + String.format("%.2f", enemytime) + " detik");
            System.out.println("sedangkan " + this.driver.nama + " kalah, dengan catatan waktu "+ String.format("%.2f", mytime) + "  detik");
        }else {
            System.out.println(enemy.driver.nama+" dan "+this.driver.nama+" seri, dengan catatan waktu "+String.format("%.2f", mytime)+" detik");
        }

        
    }
    public void checkStatus(){
        System.out.println("===== Driver Status =====");
        System.out.println("Nama : " + this.driver.nama);
        System.out.println("Mobil : " + this.car.merk);
        System.out.println("Top Speed : " + this.car.topspeed);
        System.out.println("Handling : " + this.driver.handling);
    }
    public void trek(){
        List<TrackSection> track = buatTrack(this.tikungan);
        

        System.out.println("Rute :");
        for (TrackSection i : track){
            System.out.println(i.getAll());
        }

    }
}

class TrackSection {
    String model;
    int jarak;

    public TrackSection(String type, int jarak) {
        this.model = type;
        this.jarak = jarak;
    }

    public String getAll() {
        return model + " (" + jarak + "m)";
    }
}
