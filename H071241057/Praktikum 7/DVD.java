public class DVD extends LibraryItem {
    int minute;

    DVD(String t, int itemid, int minute){
        super(t, itemid);
        this.minute = minute;
    }

    @Override
    public String borrowItem(int days) {
         if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 7) {
            throw new IllegalArgumentException("DVD hanya boleh dipinjam maksimal 7 hari.");
        }
        isBorrowed =true;
        return tittle +" berhasil dipinjam selama "+ days + "hari.";
    }

    @Override
    public String getDescription() {
        return "Buku: "+ tittle + " durasi "+ minute + "menit ,ID: "+itemid;
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }
}
