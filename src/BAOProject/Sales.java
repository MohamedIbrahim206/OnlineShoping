package BAOProject;


import DAOProject.*;
import DTOProject.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sales {
    private List<Payments> sold = new ArrayList<>();
    private Sellable tn = new DaoFactoryPro().getClassDao();

    public void makePayment (Customers customer , Cart cart){
        sold.add(new Payments(customer, cart));
        Map< Product, Number> theCart = cart.getCart();

        // Not valid
        for(Product product : theCart.keySet()){
            if(product instanceof CountableProducts){
                int currentAmount = (int) product.getAmount();
                int soldAmount = (int) theCart.get(product);
                product.setAmount(currentAmount-soldAmount);
            }
            else {
                float currentAmount = (float) product.getAmount();
                float soldAmount = (float) theCart.get(product);
                product.setAmount(currentAmount-soldAmount);
            }
        }
    }
}
