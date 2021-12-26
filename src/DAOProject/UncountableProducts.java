package DAOProject;

import DTOProject.Products;

public class UncountableProducts extends Products implements Sellable{
    public UncountableProducts(int id, String name, Number amount, float price) {
        super(id, name, amount, price);
    }

    @Override
    public float getCost(){
        return super.getPrice();
    }
    public void  updateAmount(Number n){
        super.setAmount(n);
    }
    public float getWeight(){
        return (float) super.getAmount();
    }
    public int getNum(){
        return 0;
    }
}
