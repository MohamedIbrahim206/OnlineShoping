package DAOProject;

import DTOProject.Product;

public class CountableProducts extends Product implements Sellable{

    public CountableProducts(){}
    public CountableProducts(int id , String name , Number amount , float price){
        super(id , name , amount , price);
    }

    @Override
    public int getNum(){
        return (int) super.getAmount();
    }
    public float getCost(){
        return super.getPrice();
    }
    public void  updateAmount(Number n){
        super.setAmount(n);
    }
    public float getWeight(){
        return 0;
    }
}
