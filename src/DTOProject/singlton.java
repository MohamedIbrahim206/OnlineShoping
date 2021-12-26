package DTOProject;

public class singlton {
    private singlton(){};
    private static final singlton instance =new singlton();

    public static singlton getInstance() {
        return instance;
    }
}
