package BAOProject;

import DAOProject.*;
import DTOProject.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart implements InterCart{
    private float total;
    private Map<Product, Number> cart = new HashMap<>();

    @Override
    public void addProduct(Product product , Number amount){
        cart.put(product , amount);
        total += (product.getPrice() * (int)amount);
    }
    public void removeProduct(Product product){
        cart.remove(product);
        total -= product.getPrice();
    }
    public int getNumberOfProducts(){
        return cart.size();
    }
    public float getTotal(){
        return total;
    }
    public Map<Product , Number> getCart(){
        return cart;
    }
    public void removeCart(){
        cart.clear();
    }
}
