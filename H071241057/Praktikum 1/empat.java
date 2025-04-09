import java.util.Scanner;

public class empat {
    public static void main(String args[]){ 
        Scanner sc = new Scanner(System.in);
        try {
            int x = sc.nextInt();
            System.out.println(factorial(x));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        sc.close();
        }  
    public static int factorial(int n){ 
        return n == 0 ? 1 : n * factorial(n-1);
    }
    
}
