package BAOProject;

import DAOProject.Sellable;
import DTOProject.Product;

import java.util.Map;

public interface InterCart {
    public void addProduct(Product product , Number amount);
    public void removeProduct(Product product);
    public int getNumberOfProducts();
    public float getTotal();
    public void removeCart();
    public Map<Product , Number>  getCart();
}
