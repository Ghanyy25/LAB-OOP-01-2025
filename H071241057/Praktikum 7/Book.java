public class Book extends LibraryItem {
    String author;

    Book(String t, int itemid, String author){
        super(t, itemid);
        this.author = author;
    }

    @Override
    public String borrowItem(int days) {
         if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Buku hanya boleh dipinjam maksimal 14 hari.");
        }
        isBorrowed =true;
        return tittle +" berhasil dipinjam selama "+ days + "hari.";
    }

    @Override
    public String getDescription() {
        return "Buku: "+ tittle + " oleh "+ author + " ,ID: "+itemid;
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}
