package ViewProject;

import BAOProject.*;
import DTOProject.Customers;
import DTOProject.Products;
import java.util.Scanner;

public class CustomersView {
    boolean getOut = false;

    public static void main(String args[]){

        InterCart business = new BaoFactoryPro().getClassCart();
        WarehouseInter business1 = new BaoFactoryPro().getClassBao();

        Scanner in = new Scanner(System.in);
        CustomersView cv1 = new CustomersView();
        Customers c1 = new Customers();
        Products product = new Products();
        Sales s1 = new Sales();
        Cart myCart = new Cart();

        System.out.println("please enter your name :");
        c1.setName(in.next());
        System.out.println("please enter your phone number :");
        c1.setPhone(in.next());
        c1 = new Customers(c1.getName() , c1.getPhone());

        while (!cv1.getOut){
            business1.viewProducts();
            System.out.println("which product do you want to put into the cart ? (enter it's id) ");
            System.out.println("or if you want to exit enter any letter else");

            try {
                product.setId(in.nextInt());
                // check num 5

                System.out.println("the amount you want ?");
                Number amo = in.nextInt();
                business.addProduct(business1.getProduct(product.getId()), amo);

                System.out.println("the product is added successfully");
                System.out.println("do you want to add more products ? (Y/N)");
                if(in.next().toLowerCase().equals("y"))
                    continue;
                else
                    cv1.getOut = true;
            }catch (Exception e){
                break;
            }

            System.out.println("your total is "+business.getTotal());
            System.out.println("are you sure to pay ? (Y/N)");
            // at body of if I think that not valid
            if(in.next().toLowerCase().equals("y"))
                s1.makePayment(c1 , myCart);
            else
                business.removeCart();
        }
        cv1.getOut = false;
    }
}
