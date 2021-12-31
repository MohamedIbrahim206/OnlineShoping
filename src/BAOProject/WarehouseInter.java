package BAOProject;

import DAOProject.Sellable;
import DTOProject.Admins;
import DTOProject.Product;

public interface WarehouseInter {
    public void viewProducts(departmentsEnum d);
    public Product getProduct(int id , departmentsEnum d);
    public void deleteProduct(Admins a , int id , departmentsEnum d);
    public void addProduct(Admins a , String name , Number amount , float price , departmentsEnum department);
    public void modifyProduct(Admins a , int id  , String name , Number amount , float price , departmentsEnum d);
    public int getSize();
    public void viewDepartments();
    public departmentsEnum getDepartment(int i);
}
