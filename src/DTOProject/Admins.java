package DTOProject;

public class Admins {
    private static final String userName1 , password1;
    static {
        userName1 = "Mohammed";
        password1 = "Mo1020h$";
    }
    private static final String userName2 , password2;
    static {
        userName2 = "Mostafa";
        password2 = "Mo3040h$";
    }
    public Admins(){}
    public  boolean logIn(String userName , String password){
        return userName1.equals(userName) && password1.equals(password) || userName2.equals(userName) && password2.equals(password);
    }
    public  Admins getAccess(String userName , String password){
        if(logIn(userName, password))
             singlton.getInstance();
        return null;
    }
}
