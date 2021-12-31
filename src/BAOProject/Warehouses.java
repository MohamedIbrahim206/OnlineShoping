package BAOProject;

import DAOProject.*;
import DTOProject.Admins;
import DTOProject.product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Warehouses implements WarehouseInter {
    private static int numOfProducts ;

    private HashMap<departmentsEnum , ArrayList<product>> map = new HashMap<>();
    private List<product> products = new ArrayList<>();
    Admins a1=new Admins();

    @Override
    public int getSize(){
        return numOfProducts;
    }

    public void viewProducts (departmentsEnum d){
        for (DTOProject.product product : map.get(d))
            System.out.println(product);
    }

    public void viewDepartments(){
        int i = 0;
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
        product temp;
        if(amount instanceof Integer) {
            temp = new CountableProducts(products.size(), name, amount, price);
            map.get(department).add(temp);
            temp.setId(numOfProducts);
        }
        else {
            temp = new UncountableProducts(products.size(), name, amount, price);
            map.get(department).add(temp);
            temp.setId(numOfProducts);
        }
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
