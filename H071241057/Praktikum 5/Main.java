import java.util.Scanner;


public class Main {
    public void Menu(Hero hero){
        Scanner sc = new Scanner(System.in);
        while (true) {
        System.out.println("Menu :");
        System.out.println("1. Serang");
        System.out.println("2. Keluar");
        System.out.print("Pilih aksi :");
        int x = sc.nextInt();
        sc.nextLine();

        if (x == 1) {
            hero.serang();
            System.out.println("");
        } else {
            break;
        }

        
        }
        sc.close();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        Hero fg = new Fighter("Fighter", 2000, 15);
        Hero arch = new Archer("Archer", 1800, 18);
        Hero wz = new Wizard("Wizard", 1500, 20);
        
        System.out.println("Pilih Karakter :");
        System.out.println("1. Fighter");
        System.out.println("2. Archer");
        System.out.println("3. Wizard");
        System.out.print("Masukkan pilihan :");
        int n = sc.nextInt();
        sc.nextLine();
        switch (n) {
            case 1:
                m.Menu(fg);
                break;
                case 2:
                m.Menu(arch);
                break;
            case 3:
                m.Menu(wz);
                break;
            default:
                break;
            }
        sc.close();
    }
}
