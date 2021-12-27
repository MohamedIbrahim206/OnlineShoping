package BAOProject;

import DAOProject.Sellable;
import DTOProject.Admins;

public interface WarehouseInter {
    public void viewProducts();
    public void viewDepartments();
    public Sellable getProduct(int id);
    public void deleteProduct(Admins x , int id);
    public void addProduct(Admins a , String name , Number amount , float price);
    public void modifyProduct(Admins y , int id , String name , Number amount , float price);
    public int getSize();
}
