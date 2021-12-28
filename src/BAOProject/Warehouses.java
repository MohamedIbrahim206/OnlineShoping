package BAOProject;

import DAOProject.*;
import DTOProject.Admins;
import DTOProject.Departments;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum departmentsEnum {Meats , Legumes , DiartyProducts , Vegetables}

public class Warehouses implements WarehouseInter {
    private HashMap<departmentsEnum , ArrayList> map = new HashMap<>();
    private List<Departments> products = new ArrayList<>();
    Admins a1=new Admins();

    @Override
    public int getSize(){
        return products.size();
    }

    public void viewProducts (){
        for (Departments product : products)
            System.out.println(product);
    }
    public Sellable getProduct(int id){
        return (Sellable) products.get(id);
    }
    public void addProduct(Admins a , String name , Number amount , float price , departmentsEnum departments){
        if(amount instanceof Integer)
            map.get(departments).add(new CountableProducts(products.size(), name , amount , price));
        else
            map.get(departments).add(new UncountableProducts(products.size(), name , amount , price));
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
}
