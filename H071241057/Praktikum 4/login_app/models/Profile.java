package login_app.models;

import login_app.models.Education;

public class Profile {
    /*
     * TODO:
     * Tambahkan attribute, method, atau constructor
     * yang dibutuhkan di kelas user
     */
    public String fullname;
    public String nickname;
    public int age;
    public String hobby;
    public Education edu = new Education();
    

    public Profile(){

    }
    public Profile(String name,int age,String hobby){
        this.fullname = name;
        this.age = age;
        this.hobby = hobby;

    }
}