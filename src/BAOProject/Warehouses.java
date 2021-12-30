package BAOProject;

import DAOProject.*;
import DTOProject.Admins;
import DTOProject.Departments;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouses implements WarehouseInter {
    private static int numOfProducts ;

    private HashMap<departmentsEnum , ArrayList<Departments>> map = new HashMap<>();
    private List<Departments> products = new ArrayList<>();
    Admins a1=new Admins();

    @Override
    public int getSize(){
        return numOfProducts;
    }

    public void viewProducts (departmentsEnum d){
        for (Departments product : map.get(d))
            System.out.println(product);
    }

    public void viewDepartments(){
        int i = 0;
        for (departmentsEnum d : departmentsEnum.values())
            System.out.println(i+"- "+d);
    }
    public Sellable getProduct(int id , departmentsEnum d){
        for (Departments product : map.get(d))
            if (product.getId() == id)
                return (Sellable) map.get(d).get(id);
        return null;
    }
    public void addProduct(Admins a , String name , Number amount , float price , departmentsEnum department){
        Departments temp;
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
    public void deleteProduct(Admins a , Departments product , departmentsEnum d){
        map.get(d).remove(product);

    }
    public void modifyProduct(Admins a , Departments product  , String name , Number amount , float price ){
        product.setName(name);
        product.setAmount(amount);
        product.setPrice(price);
    }
}
