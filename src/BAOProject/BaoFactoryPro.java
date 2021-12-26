package BAOProject;

public class BaoFactoryPro {
    public WarehouseInter getClassBao(){
        return new Warehouses();
    }
    public InterCart getClassCart(){
        return new Cart();
    }
}
