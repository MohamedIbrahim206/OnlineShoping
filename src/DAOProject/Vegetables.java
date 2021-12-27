package DAOProject;

import DTOProject.Admins;
import DTOProject.Departments;
import java.util.ArrayList;
import java.util.List;

public class Vegetables extends Departments{

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
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Tomato",20,4);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Carrot",10,5);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Beans",25,12);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Potatos",15,6);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Cucumber",13,5);
    }
    @Override
    public String toString() {
        return "id=" + product.getId() + ", name= " + product.getName() + ", price= " + product.getPrice() + ", amount= " + product.getAmount();
    }
}
