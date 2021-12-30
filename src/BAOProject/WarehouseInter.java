package BAOProject;

import DAOProject.Sellable;
import DTOProject.Admins;
import DTOProject.Departments;

public interface WarehouseInter {
    public void viewProducts(departmentsEnum d);
    public Sellable getProduct(int id , departmentsEnum d);
    public void deleteProduct(Admins a , Departments product , departmentsEnum d);
    public void addProduct(Admins a , String name , Number amount , float price , departmentsEnum department);
    public void modifyProduct(Admins a , Departments product  , String name , Number amount , float price);
    public int getSize();
}
