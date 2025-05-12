public class Hero{
    String name;
    int health;
    int attackpower;

    public Hero(String name, int health, int atk){
        this.name = name;
        this.health = health;
        this.attackpower = atk;
    }

    public void serang(){
        System.out.println(name+" menyerang dengan kekuatan "+attackpower);
    }

}