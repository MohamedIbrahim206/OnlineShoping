package DAOProject;

import DTOProject.Admins;
import DTOProject.Departments;
import java.util.ArrayList;
import java.util.List;

public class DiartyProducts {

    private List<Departments> products = new ArrayList<>();
    Admins a1=new Admins();
    Departments product = new Departments();
    public void addProduct(Admins a , String name , Number amount , float price){
        if(amount instanceof Integer)
            products.add(new CountableProducts(products.size(), name , amount , price));
        else
            products.add(new UncountableProducts(products.size(), name , amount , price));
    }

    {
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Milk",8,12);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Cheese",10,15);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Yogurt",20,2);
    }
    @Override
    public String toString() {
        return "id=" + product.getId() + ", name= " + product.getName() + ", price= " + product.getPrice() + ", amount= " + product.getAmount();
    }
}
