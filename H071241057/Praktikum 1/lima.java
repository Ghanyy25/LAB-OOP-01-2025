import java.util.Scanner;

public class lima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.print("masukkan password : ");
        String pass = sc.nextLine();
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";

        if (pass.matches(regex)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
        sc.close();
    }
}
