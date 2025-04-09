import java.util.Scanner;
// import java.util.Arrays;

    
public class satu {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String n = sc.nextLine();
    String[] kata = n.split(" ");
    
    for (int i = 0; i < kata.length; i++) {
        if (!kata[i].isEmpty()) {
            String lower = kata[i].toLowerCase();
            kata[i] = kata[i].substring(0,1).toUpperCase() +lower.substring(1);

            System.out.print(kata[i]+" ");
        }
        
    }
    // System.err.println(Arrays.toString(kata));

    sc.close();
}
}