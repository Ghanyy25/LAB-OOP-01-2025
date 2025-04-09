import java.util.Random;
import java.util.Scanner;



public class dua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int[][] matriks = new int [3][3];
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks.length; j++) {
                matriks[i][j] = rd.nextInt(10);
            }
        }
        int counter = 0;
        try {
            int n = sc.nextInt(); 
            for (int i = 0; i < matriks.length; i++) {
                for (int j = 0; j < matriks.length; j++){
                    if ( n == matriks[i][j]) {
                       counter+=1;
                        System.out.printf("Found %d at [%d][%d]\n", n,i+1,j+1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (counter==0) {
            System.err.println("tidak ada angka di matriks.");
            
        } 
        sc.close();
    }
}
