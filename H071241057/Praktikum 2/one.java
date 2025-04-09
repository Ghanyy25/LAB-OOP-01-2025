// import java.util.Scanner;

public class one {
    String name;
    int age;
    boolean isMale;

    public void setName(String nama){
        this.name = nama; 
    }
    public void setAge(int umur){
        this.age = umur;
    }
    public void setName(boolean gender){
        this.isMale = gender; 
    }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public boolean getGender(){
        return this.isMale;
    }
}
