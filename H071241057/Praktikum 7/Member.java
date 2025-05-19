import java.util.ArrayList;

public class Member {
    String name;
    int memberid;
    ArrayList<LibraryItem> borroweditem = new ArrayList<>();

    public Member(String name, int memberid) {
        this.name = name;
        this.memberid = memberid;
    }

    public int getMemberId() {
        return memberid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return memberid + " - " + name;
    }

    public String borrow(LibraryItem item, int days){
        if (item.getIsBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia (sudah dipinjam).");
        }
        // item.borrowItem(days);
        borroweditem.add(item);
        return item.borrowItem(days);
    }

    public String returnItem(LibraryItem item, int daysLate){
        if (!borroweditem.contains(item)) {
            return "Item tidak ditemukan dalam daftar pinjaman.";
        }

        double fine = item.calculateFine(daysLate);
        borroweditem.remove(item);
        return item.returnItem() +" dengan denda Rp "+ fine;
    }

    public void getBorrowedItems() {
        if (borroweditem.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
        } else {
        System.out.println("+------+----------------------+");
        System.out.println("| ID   | Judul                |");
        System.out.println("+------+----------------------+");

        for (LibraryItem item : borroweditem) {
            System.out.printf("| %-4d | %-20s |\n", item.itemid, item.tittle);
        }
        

        System.out.println("+------+----------------------+");
        }
    }
    
}

