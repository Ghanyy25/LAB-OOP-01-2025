import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== Menu Perpustakaan =====");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Member");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Item");
            System.out.println("6. Lihat Log");
            System.out.println("7. Lihat Daftar Member");
            System.out.println("8. Lihat Item Member");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka.");
                continue; 
            }

            switch (pilihan) {
                case 1:
                    System.out.println("1. Tambah Buku");
                    System.out.println("2. Tambah DVD");
                    System.out.print("> ");
                    int pilih = scanner.nextInt();
                    scanner.nextLine();
                    switch(pilih){
                        case 1:
                            System.out.print("Judul buku: ");
                            String title = scanner.nextLine();
                            System.out.print("ID item: ");
                            int id;
                            try {
                                id = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Input tidak valid! Masukkan angka.");
                                continue; 
                            }
                            boolean i = true;
                            for (LibraryItem item : library.items) {
                                if (item.itemid == id) {
                                    System.out.println("Gunakan id lain, id ini sudah digunakan oleh "+ item.tittle);
                                    i = false;
                                }
                            }
                            if (!i) {
                                break;
                            }
                            System.out.print("Author: ");
                            String author = scanner.nextLine();
                            Book book = new Book(title, id, author);
                            System.out.println(library.addItem(book));
                            break;

                        case 2:
                            System.out.print("Judul DVD: ");
                            String t = scanner.nextLine();
                            System.out.print("ID item: ");
                            int j ;
                            try {
                                j = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Input tidak valid! Masukkan angka.");
                                continue; 
                            }
                            boolean k = true;
                            scanner.nextLine();
                            for (LibraryItem item : library.items) {
                                if (item.itemid == j) {
                                    System.out.println("Gunakan id lain, id ini sudah digunakan oleh "+ item.tittle);
                                    k = false;
                                }
                            }
                            if (!k) {
                                break;
                            }
                            System.out.print("Durasi (menit): ");
                            int d = scanner.nextInt();
                            scanner.nextLine();
                            DVD dvd = new DVD(t, j, d);
                            System.out.println(library.addItem(dvd));
                            break;

                        default :
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 2:
                    System.out.print("Nama member: ");
                    String name = scanner.nextLine();
                    System.out.print("ID member: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();
                    Member member = new Member(name, memberId);
                    library.addMember(member);
                    System.out.println("Member berhasil ditambahkan.");
                    library.getLogger().logActivity("Member : "+ name + " menjadi member baru ");
                    break;

                case 3:
                    System.out.print("ID member: ");
                    int memId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID item: ");
                    int itemId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Berapa hari pinjam? ");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Member m = library.findMemberById(memId);
                        LibraryItem item = library.findItemById(itemId);
                        String result = m.borrow(item, days);
                        System.out.println(result);
                        library.getLogger().logActivity(item.getClass().getSimpleName() + ": "+ item.getTittle()+ " dipinjam oleh " + m.getName());
                    } catch (Exception e) {
                        System.out.println("Gagal: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("ID member: ");
                    int memReturnId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID item: ");
                    int itemReturnId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Berapa hari terlambat? ");
                    int late = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Member m = library.findMemberById(memReturnId);
                        LibraryItem item = library.findItemById(itemReturnId);
                        String result = m.returnItem(item, late);
                        System.out.println(result);
                        library.getLogger().logActivity(item.getClass().getSimpleName() +" : "+ item.getTittle() + " dikembalikan oleh " + m.getName());
                    } catch (Exception e) {
                        System.out.println("Gagal: " + e.getMessage());
                    }
                    break;

                case 5:
                    // System.out.println("Status Item:");
                    library.getLibraryStatus();
                    break;

                case 6:
                    System.out.println("Log Aktivitas:");
                    System.out.println(library.getAllLogs());
                    break;

                case 7:
                    if (library.members.isEmpty()) {
                    System.out.println("Tidak ada item yang dipinjam.");
                    } else {
                    System.out.println("+------+----------------------+");
                    System.out.println("| ID   | Nama                 |");
                    System.out.println("+------+----------------------+");

                    for (Member item : library.members) {
                        System.out.printf("| %-4d | %-20s |\n", item.memberid, item.name);
                    }

                    System.out.println("+------+----------------------+");
                    }
                    break;

                case 8:
                    System.out.print("ID member: ");
                    int memd = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Member m = library.findMemberById(memd);
                        m.getBorrowedItems();
                    } catch (Exception e) {
                        System.out.println("Gagal: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
