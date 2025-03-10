import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
    
public class tiga {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dfo = new SimpleDateFormat("dd-MM-yy");
        SimpleDateFormat dfn = new SimpleDateFormat("d MMMM yyyy");

        String tanggal = sc.nextLine();

        try {
            Date date = dfo.parse(tanggal);

            String baru = dfn.format(date);
            System.out.println(baru); 
        } catch (ParseException e) {
            // TODO: handle exception
            System.out.println(e.toString());
        }
        sc.close();
    }
}