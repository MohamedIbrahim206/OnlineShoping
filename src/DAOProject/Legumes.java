package DAOProject;

import DTOProject.Admins;
import DTOProject.Departments;

import java.util.ArrayList;
import java.util.List;

public class Legumes extends Departments {

    // Repetition code !
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
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Rice",50,9);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Macaroni",40,6.5f);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Sugar",25,8);
        addProduct(a1.getAccess("Mohammed","Mo1020h$"),"Salt",30,2);
    }
    @Override
    public String toString() {
        return "id=" + product.getId() + ", name= " + product.getName() + ", price= " + product.getPrice() + ", amount= " + product.getAmount();
    }
}
