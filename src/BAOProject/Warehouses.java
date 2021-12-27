package BAOProject;

import DAOProject.*;
import DTOProject.Admins;
import DTOProject.Departments;
import java.util.ArrayList;
import java.util.List;

public class Warehouses<k> implements WarehouseInter {
    private List<Departments> products = new ArrayList<>();
    Admins a1=new Admins();

    @Override
    public int getSize(){
        return products.size();
    }
    public void viewProducts() {
        if (products instanceof Departments) {
            for (Departments products : products)
                System.out.println(products);
        }
    }
    public void ViewMeats() {
        List<Meats> elements = new ArrayList<>();
        if (elements instanceof Meats) {
            for (Meats element : elements)
                System.out.println(element);
        }
    }
    public void ViewLegumes() {
        List<Legumes> elements = new ArrayList<>();
        if (elements instanceof Legumes) {
            for (Legumes element : elements)
                System.out.println(element);
        }
    }
    public void ViewVegetables() {
        List<Vegetables> elements = new ArrayList<>();
        if (elements instanceof Vegetables) {
            for (Vegetables element : elements)
                System.out.println(element);
        }
    }
    public void ViewDiarty() {
        List<DiartyProducts> elements = new ArrayList<>();
        if (elements instanceof DiartyProducts) {
            for (DiartyProducts element : elements)
                System.out.println(element);
        }
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
}
