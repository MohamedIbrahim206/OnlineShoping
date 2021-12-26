package BAOProject;

import DAOProject.CountableProducts;
import DAOProject.Sellable;
import DAOProject.UncountableProducts;
import DTOProject.Admins;
import DTOProject.Departments;
import java.util.ArrayList;
import java.util.List;

public class Warehouses implements WarehouseInter {
    private List<Departments> products = new ArrayList<>();
    Admins a1=new Admins();

    @Override
    public int getSize(){
        return products.size();
    }
    public void viewProducts(){
        for(Departments products : products)
            System.out.println(products);
    }
    public Sellable getProduct(int id){
        return (Sellable) products.get(id);
    }
    public void addProduct(Admins a , String name , Number amount , float price){
        if(amount instanceof Integer)
            products.add(new CountableProducts(products.size(), name , amount , price));
        else
            products.add(new UncountableProducts(products.size(), name , amount , price));
    }
    public void deleteProduct(Admins a , int id){
        products.remove(id);
    }
    public void modifyProduct(Admins a , int id , String name , Number amount , float price){
        Departments product = products.get(id);
        product.setName(name);
        product.setAmount(amount);
        product.setPrice(price);
    }
    {
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Rice",20,9);
    }
}
