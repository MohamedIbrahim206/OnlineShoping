package DTOProject;

import BAOProject.Cart;

public class Payments{
    private Customers customer;
    private Cart cart;

    public Payments(Customers customer , Cart cart){
        this.customer = customer;
        this.cart = cart;
    }

    public Customers getCustomer(){
        return customer;
    }
    public Cart getCart() {
        return cart;
    }
}
