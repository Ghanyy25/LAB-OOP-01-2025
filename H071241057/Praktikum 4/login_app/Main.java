package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
// import login_app.models.Education;
import login_app.models.User;
import login_app.utils.Stringutils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Memanggil method runApp();
        runApp();
    }

    private static void runApp() {
        // Menu Utama Aplikasi
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        // Menginput pilihan menu
        try {
            int selectMenu = sc.nextInt();
            sc.nextLine();
            switch (selectMenu) {
                case 1:
                    showLoginMenu();
                    break;
                case 2:
                    showRegisterMenu();
                    // break;
                default:
                    
                    runApp();
            }
        } catch (Exception e) {
            System.out.println("Masukkan angka 1 atau 2 saja.");
            sc.nextLine();
            runApp();
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");


        // Menginput Username dan Menyimpannya di attribute username;
        System.out.println("Masukkan Username");
        System.out.print("> ");
        String username = sc.nextLine();
        while (username.trim().isEmpty()) {
            System.out.println("Ketikkan username");
            System.out.print("> ");
            username = sc.nextLine();
        }


        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        /*
        * TODO
        * Buatlah sebuah perkondisian (IF) yang akan
        * Mengecek apakah user index ke i dari listUser memiliki username yang sama
        * dengan username yang
        * diinput.
        * Jika ada ganti userIndex dengan Index dari User Tersebut, kemudian hentikan
        * perulangan
        */
            for (int i = 0; i < listUser.size(); i++) {
            User anggota = listUser.get(i);
            if (username.equals(anggota.name)){
                userIndex = i;
            
            }
        }


        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();
            while (password.trim().isEmpty()) {
                System.out.println("Ketikkan password");
                System.out.print("> ");
                password = sc.next();
            }
    

            /*
             * TODO
             * Mengecek apakah password dari User yang login berdasarkan username
             * sama dengan password yang diinput sebelumnya, kemudian simpan
             * hasilnya di variabel isPasswordMatch
             */
            // Jika passwordnya sama maka berhasil login
            boolean isPasswordMatch = listUser.get(userIndex).pass.equals(password);
            if (isPasswordMatch) {
                /*
                * TODO
                * panggil method showDetailUser dan kirimkan data Profile User yang login
                */
                System.out.println("Berhasil Login");
                Profile Profile = listUserProfile.get(userIndex);
                showDetailUser(Profile);
                System.out.println("Ingin mengupdate Pendidikan terakhir? (y/n) : ");
                String confirm = sc.next();
                if (confirm.equals("y")) {
                    System.out.println("Pendidikan terakhir");
                    System.out.print("> ");
                    String pendidikan = sc.nextLine();
                    while (pendidikan.trim().isEmpty()) {
                        System.out.println("Ketikkan pendidikan");
                        System.out.print("> ");
                        pendidikan = sc.nextLine();
                    }
                    Profile.edu.education = pendidikan;
                    showDetailUser(Profile);
                } if (confirm.equals("n")) {
                    sc.next();
                }
                else {
                    System.out.println("masukkan hanya 'y' atau 'n'");
                }
                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
            }
        }
    }


    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        System.out.println("Username");
        System.out.print("> ");
        String username = sc.nextLine();
        while (username.trim().isEmpty()) {
            System.out.println("Ketikkan username (Tidak boleh kosong!)");
            System.out.print("> ");
            username = sc.nextLine();
        }
        for (int i = 0; i < listUser.size(); i++) {
            User anggota = listUser.get(i);
            if (username.equals(anggota.name)){
                System.out.println("Username sudah digunakan.");
                showRegisterMenu();
            }
        }


        System.out.println("Password");
        System.out.print("> ");
        String password = sc.nextLine();
        while (password.trim().isEmpty()) {
            System.out.println("Ketikkan password");
            System.out.print("> ");
            password = sc.nextLine();
        }

        if (password.length()<8) {
            System.out.println("Minimal 8 karakter.");
            showRegisterMenu();
        }

        
        /*
         * TODO
         * Buatlah atau Instance objek User baru, dan tambahkan
         * username dan password yang diinput sebelumnya secara langsung
         * saat instance User
         */
        User user = new User(username, password);

        /*
         * TODO
         * Buatlah atau Instance objek Profile baru
         */
        Profile profile = new Profile();

        // Menginput Data Profile
        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();
        while (fullName.trim().isEmpty()) {
            System.out.println("Ketikkan fullName");
            System.out.print("> ");
            fullName = sc.nextLine();
        }

        System.out.println("Umur");
        System.out.print("> ");
        int age = 0;
        try {
            age = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Masukkan angka!");
            sc.nextLine();
            showRegisterMenu();
            return;
        }

        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = sc.nextLine();
        while (hobby.trim().isEmpty()) {
            System.out.println("Ketikkan hobby");
            System.out.print("> ");
            hobby = sc.nextLine();
        }

        System.out.println("Pendidikan terakhir");
        System.out.print("> ");
        String pendidikan = sc.nextLine();
        while (pendidikan.trim().isEmpty()) {
            System.out.println("Ketikkan pendidikan");
            System.out.print("> ");
            pendidikan = sc.nextLine();
        }

        /*
         * TODO
         * Berikan nilai fullName, age, dan hobby ke objek profile yang telah
         * di Instance sebelumnya. Nilai ini diperoleh dari data profile yang
         * diinput sebelumnya
         */
        profile.fullname = fullName;
        profile.age = age;
        profile.hobby = hobby;
        profile.edu.education = pendidikan;

        /*
         * TODO
         * Berikan nilai nickName ke objek profile,
         * Nilai ini diperoleh menggunakan static method yang dibuat di class
         * StringUtils, dengan mengirimkan fullName yang diinput sebelumnya
         */
        profile.nickname = Stringutils.nickName(fullName);

        // Menambahkan user yang dibuat ke list user
        listUser.add(user);

        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }


    private static void showDetailUser(Profile profile) {
        /*
        * TODO *
        * Tampilkan semua data profile user yang login
        */
        System.out.println("-------------------------");
        System.out.println("Full Name  : " + profile.fullname);
        System.out.println("Nickname   : " + profile.nickname);
        System.out.println("Age        : " + profile.age);
        System.out.println("Hobby      : " + profile.hobby);
        profile.edu.get_education();

    }
}
