public class four {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalanrea Indah";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Farhan";
        mahasiswa.nim = "H071241057";

        System.out.println("Nama: "+ mahasiswa.getNama());
        System.out.println("Nim: "+ mahasiswa.getNim());
        System.out.println("Alamat: "+ mahasiswa.getAlamat());

    }
    
}

class Alamat{
    String jalan;
    String kota;

    String getLengkap(){
        return jalan+", "+kota;
    }
}
class Mahasiswa{
    String nama;
    String nim;
    Alamat alamat;

    public String getNama(){
        return nama;
    }
    public String getNim(){
        return nim;
    }
    public String getAlamat(){
        return alamat.getLengkap();
    }
}