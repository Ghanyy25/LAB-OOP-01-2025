package blueprint;


public abstract class Kendaraan{
    String id;
    String merek;
    String model;
    int tahunProduksi;
    String warna;

    public Kendaraan(String merek, String model) {
        this.merek = merek;
        this.model = model;
    }


    public String getId() {
        return id;
    }
    public String getMerek() {
        return merek;
    }
    public String getModel() {
        return model;
    }
    public int getTahunProduksi() {
        return tahunProduksi;
    }
    public String getWarna() {
        return warna;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setMerek(String merek) {
        this.merek = merek;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }
    public void setWarna(String warna) {
        this.warna = warna;
    }
    

    public abstract double hitungPajak();
    public abstract String getTipe();


}