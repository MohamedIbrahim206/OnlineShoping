package BAOProject;

import DAOProject.Sellable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements InterCart{
    private float total;
    private Map<Sellable, Number> cart = new HashMap<>();

    @Override
    public void addProduct(Sellable product , Number amount){
        cart.put(product , amount);
        total += (product.getCost() * (int)amount);
    }
    public void removeProduct(Sellable product){
        cart.remove(product);
        total -= product.getCost();
    }
    public int getNumberOfProducts(){
        return cart.size();
    }
    public float getTotal(){
        return total;
    }
    public Map<Sellable , Number> getCart(){
        return cart;
    }
    public void removeCart(){
        cart.clear();
    }
}
