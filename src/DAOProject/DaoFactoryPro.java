package DAOProject;

public class DaoFactoryPro {
    public Sellable getClassDao(){
        return new CountableProducts();
    }
}
