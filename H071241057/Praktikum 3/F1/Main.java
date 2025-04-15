// package F1;

public class Main {
    public static void main(String[] args) {
        Race max = new Race();
        Race santoso = new Race("Lamborghini", "santoso", 8, 230, "Roma", 5);
        max.checkStatus();
        santoso.checkStatus();
        // santoso.trek();/
        santoso.start(max);
    }
}
