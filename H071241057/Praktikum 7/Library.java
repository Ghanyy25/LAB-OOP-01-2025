import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    public List<LibraryItem> items;
    public List<Member> members;
    public LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        String jenis = item.getClass().getSimpleName();
        logger.logActivity(jenis + " : "+ item.tittle + " telah ditambah ke library ");
        return item.tittle + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.itemid == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public void getLibraryStatus() {
        System.out.println("+------+-------+----------------------+-----------+");
        System.out.println("| ID   | Jenis | Judul                | Status    |");
        System.out.println("+------+-------+----------------------+-----------+");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            System.out.printf("| %-4d | %-5s | %-20s | %-8s  |\n", item.itemid,item.getClass().getSimpleName(), item.tittle, status);
        }
        System.out.println("+------+-------+----------------------+-----------+");
      
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryLogger getLogger() {
        return logger;
    }

    public Member findMemberById(int id) {
    for (Member m : members) {
        if (m.getMemberId() == id) return m;
    }
    throw new NoSuchElementException("Member tidak ditemukan.");
}

}
