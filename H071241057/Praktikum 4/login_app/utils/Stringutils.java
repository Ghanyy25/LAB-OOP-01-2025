package login_app.utils;

public class Stringutils {
    
    public static String nickName (String fullname){
        String[] pisah = fullname.split(" ");
        if (pisah.length > 1) {
            return pisah[pisah.length - 1];
        } else {
            return fullname;
        }
        
    }
}
