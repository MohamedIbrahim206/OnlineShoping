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

//    public void viewDepartments(){
//        List<Meats> elementMeat = new ArrayList<>();
//        if (elementMeat instanceof Meats) {
//            for (Meats element : elementMeat)
//                System.out.println(elementMeat);
//        }
//        List<Legumes> elementLeg = new ArrayList<>();
//        if (elementLeg instanceof Legumes) {
//            for (Legumes element : elementLeg)
//                System.out.println(elementLeg);
//        }
//        List<Vegetables> elementVeg = new ArrayList<>();
//        if (elementVeg instanceof Vegetables) {
//            for (Vegetables element : elementVeg)
//                System.out.println(element);
//        }
//    }
    public void viewProducts(){
        if (products instanceof Departments) {
            for (Departments products : products)
                System.out.println(products);
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
    // add type of departments
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
