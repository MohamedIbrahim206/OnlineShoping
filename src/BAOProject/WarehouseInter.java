package BAOProject;

import DAOProject.Sellable;
import DTOProject.Admins;
import DTOProject.product;

public interface WarehouseInter {
    public void viewProducts(departmentsEnum d);
    public Sellable getProduct(int id , departmentsEnum d);
    public void deleteProduct(Admins a , product product , departmentsEnum d);
    public void addProduct(Admins a , String name , Number amount , float price , departmentsEnum department);
    public void modifyProduct(Admins a , product product  , String name , Number amount , float price);
    public int getSize();
    public void viewDepartments();
    public departmentsEnum getDepartment(int i);
}
