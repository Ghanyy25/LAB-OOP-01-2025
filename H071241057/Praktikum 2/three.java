class Cuboid {
    double height;
    double width;
    double length;
    double getVolume() {
    return height * width * length;}
}
public class three{
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 100.0;
        cuboid.width = 15.0;
        cuboid.length = 3.0;
        System.out.printf("Volume = %.2f%n", cuboid.getVolume());
    }
    
}