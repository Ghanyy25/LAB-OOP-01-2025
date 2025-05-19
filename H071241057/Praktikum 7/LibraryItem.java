public abstract class LibraryItem {
    String tittle;
    int itemid;
    boolean isBorrowed;

    LibraryItem (String t, int i){
        this.tittle = t;
        this.itemid = i;
        this.isBorrowed =false;
    }

    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    public String getTittle() {
        return tittle;
    }

    public String returnItem(){
        isBorrowed =false;
        return tittle + "dikembalikan";
    }

    public boolean getIsBorrowed(){
        return isBorrowed;
    }

}