package BAOProject;

import DAOProject.*;
import DTOProject.Admins;
import DTOProject.Product;
import java.util.ArrayList;
import java.util.HashMap;

public class Warehouses implements WarehouseInter {
    private static int numOfProducts ;

    private static HashMap<departmentsEnum , ArrayList<Product>> map = new HashMap<>();
    {
        Admins a1 = new Admins();
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Tomato", 20, 4, departmentsEnum.Vegetables);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Carrot", 10, 5, departmentsEnum.Vegetables);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Beans", 25, 12, departmentsEnum.Vegetables);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Potatos", 15, 6, departmentsEnum.Vegetables);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Cucumber", 13, 5, departmentsEnum.Vegetables);

        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Chicken", 5, 35, departmentsEnum.Meats);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Fish", 10, 30, departmentsEnum.Meats);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Meats", 25, 130, departmentsEnum.Meats);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Luncheon", 15, 40, departmentsEnum.Meats);

        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Rice", 50, 9, departmentsEnum.Legumes);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Macaroni", 40, 6.5f, departmentsEnum.Legumes);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Sugar", 25, 8, departmentsEnum.Legumes);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Salt", 30, 2, departmentsEnum.Legumes);

        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Milk", 8, 12, departmentsEnum.DiartyProducts);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Cheese", 10, 15, departmentsEnum.DiartyProducts);
        addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Yogurt", 20, 2, departmentsEnum.DiartyProducts);

    }

    static {
        for (departmentsEnum p : departmentsEnum.values())
            map.put(p , new ArrayList<>());
    }
    //Admins a1=new Admins();

    @Override
    public int getSize(){
        return numOfProducts;
    }

    public void viewProducts (departmentsEnum d){
        for (Product product : map.get(d))
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
    public Product getProduct(int id , departmentsEnum d){
        for (Product product : map.get(d))
            if (product.getId() == id)
                return  product;
        return null;
    }
    public void addProduct(Admins a , String name , Number amount , float price , departmentsEnum department){
        if(amount instanceof Integer)
            map.get(department).add(new CountableProducts(numOfProducts, name, amount, price));
        else
            map.get(department).add(new UncountableProducts(numOfProducts, name, amount, price));

        numOfProducts++;
    }
    public void deleteProduct(Admins a , int id , departmentsEnum d){
        map.get(d).remove(id );
    }
    public void modifyProduct(Admins a , int id  , String name , Number amount , float price , departmentsEnum d){
        Product product = map.get(d).get(id);
        product.setName(name);
        product.setAmount(amount);
        product.setPrice(price);
    }
}
