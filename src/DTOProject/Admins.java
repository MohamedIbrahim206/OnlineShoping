package DTOProject;

public class Admins {
    private static final String userName , password;
    static {
        userName = "Mohammed";
        password = "Mo1020h$";
    }
    public Admins(){}
    public  boolean logIn(String userName , String password){
        return userName.equals(userName) && password.equals(password);
    }
    public  Admins getAccess(String userName , String password){
        if(logIn(userName, password))
             singlton.getInstance();
        return null;
    }
}
