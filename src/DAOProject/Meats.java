package DAOProject;

import DTOProject.Admins;
import DTOProject.Departments;

import java.util.ArrayList;
import java.util.List;

public class Meats extends Departments {

    private List<Departments> products = new ArrayList<>();
    Admins a1=new Admins();
    public void addProduct(Admins a , String name , Number amount , float price){
        if(amount instanceof Integer)
            products.add(new CountableProducts(products.size(), name , amount , price));
        else
            products.add(new UncountableProducts(products.size(), name , amount , price));
    }

    {
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Chicken",5,35);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Fish",10,30);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Meats",25,130);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Luncheon",15,40);
    }
}
