package BAOProject;

import DAOProject.CountableProducts;
import DAOProject.DaoFactoryPro;
import DAOProject.Sellable;
import DTOProject.Customers;
import DTOProject.Payments;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sales {
    private List<Payments> sold = new ArrayList<>();
    private Sellable tn = new DaoFactoryPro().getClassDao();

    public void makePayment (Customers customer , Cart cart){
        sold.add(new Payments(customer, cart));
        Map<Sellable , Number> theCart = cart.getCart();

        // Not valid
        for(Sellable product : theCart.keySet()){
            if(product instanceof CountableProducts){
                int currentAmount = (int) product.getAmount();
                int soldAmount = (int) theCart.get(product);
                product.updateAmount(currentAmount-soldAmount);
            }
            else {
                float currentAmount = (float) product.getAmount();
                float soldAmount = (float) theCart.get(product);
                product.updateAmount(currentAmount-soldAmount);
            }
        }
    }
}
