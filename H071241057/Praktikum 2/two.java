public class Two {
    String id;
    String nama;
    int stok = 0;
    int harga = 0;

    public String cekData(){
        return "id : " + this.id + "\nnama : " + this.nama + "\nstok : " + this.stok + "\nharga : " + this.harga;
    }

    public String cekStok(){
        if (this.stok>0) {
            return "Stok masih ada " + this.stok;
        } else {
            return "Stok tidak ada";
        }
    }
    
    public static void main(String[] args) {
        two tempe = new two();
        tempe.id = "091871";
        tempe.nama = "tempe";
        tempe.stok= 5;
        tempe.harga = 5000;
        System.out.println(tempe.cekData()); 
        System.out.println(tempe.cekStok()); 
    }
}
