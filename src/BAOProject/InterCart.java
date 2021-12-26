package BAOProject;

import DAOProject.Sellable;

import java.util.Map;

public interface InterCart {
    public void addProduct(Sellable product , Number amount);
    public void removeProduct(Sellable product);
    public int getNumberOfProducts();
    public float getTotal();
    public void removeCart();
    public Map<Sellable, Number> getCart();
}
