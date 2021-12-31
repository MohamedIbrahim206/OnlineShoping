package BAOProject;

import DAOProject.*;
import DTOProject.Admins;
import DTOProject.product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Warehouses implements WarehouseInter {
    private static int numOfProducts ;

    private static HashMap<departmentsEnum , ArrayList<product>> map = new HashMap<>();

    static {
        for (departmentsEnum p : departmentsEnum.values())
            map.put(p , new ArrayList<>());
    }

    Admins a1=new Admins();

    @Override
    public int getSize(){
        return numOfProducts;
    }

    public void viewProducts (departmentsEnum d){

        for (DTOProject.product product : map.get(d))
            System.out.println(product);
    }

    public departmentsEnum getDepartment(int i){

        return switch (i) {
            case 1 -> departmentsEnum.Meats;
            case 2 -> departmentsEnum.Legumes;
            case 3 -> departmentsEnum.DiartyProducts;
            case 4 -> departmentsEnum.Vegetables;
            default -> null;
        };

    }
    public void viewDepartments(){
        int i = 1;
        for (departmentsEnum d : departmentsEnum.values())
            System.out.println((i++)+"- "+d);
    }
    public Sellable getProduct(int id , departmentsEnum d){
        for (DTOProject.product product : map.get(d))
            if (product.getId() == id)
                return (Sellable) map.get(d).get(id);
        return null;
    }
    public void addProduct(Admins a , String name , Number amount , float price , departmentsEnum department){


        if(amount instanceof Integer)
            map.get(department).add(new CountableProducts(numOfProducts, name, amount, price));

        else
            map.get(department).add(new UncountableProducts(numOfProducts, name, amount, price));


        numOfProducts++;
    }
    public void deleteProduct(Admins a , product product , departmentsEnum d){
        map.get(d).remove(product);
    }
    public void modifyProduct(Admins a , product product  , String name , Number amount , float price ){
        product.setName(name);
        product.setAmount(amount);
        product.setPrice(price);
    }
}
