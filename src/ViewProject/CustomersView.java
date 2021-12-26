package ViewProject;

import BAOProject.*;
import DTOProject.Customers;
import DTOProject.Products;
import java.util.Scanner;

public class CustomersView {
    boolean getOut = false;
    public static boolean onlyAlphabets(String str, int n)
    {
        if (str == null || str == "") {
            return false;
        }
        for (int i = 0; i < n; i++) {

            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean onlyDigits(String num,int n){
        if (num == null || num == "") {
            return false;
        }
        for (int i = 0; i < n; i++){

            if(!Character.isDigit(num.charAt(i))&&n!=11){
                return false;
            }
        }
        return true;

    }


    public static void main(String args[]){

        InterCart business = new BaoFactoryPro().getClassCart();
        WarehouseInter business1 = new BaoFactoryPro().getClassBao();

        Scanner in = new Scanner(System.in);
        CustomersView cv1 = new CustomersView();
        Customers c1 = new Customers();
        Products product = new Products();
        Sales s1 = new Sales();
        Cart myCart = new Cart();


        while(true){
            System.out.println("please enter your name : ");
            String name=in.next();
            int n=name.length();
            if(onlyAlphabets(name,n)==true){
                c1.setName(name);
                break;
            }
            else
                System.out.println("please enter valid name(Only characters)");
        }
        while(true) {
            System.out.println("please enter your phone number :");
            String phoneNumber = in.next();
            int n = phoneNumber.length();
            if(onlyDigits(phoneNumber,n)==true){
                c1.setPhone(phoneNumber);
                break;

            }
            else
                System.out.println("Please enter valid phone number (only digits)");

        }
        c1 = new Customers(c1.getName(), c1.getPhone());
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
            if(in.next().toLowerCase().equals("y")) {
                s1.makePayment(c1, myCart);
                System.out.println("Payment completed successfully , Good luck");
            }

            else{
                business.removeCart();
                System.out.println("Not paid\n");

            }
        }
        cv1.getOut = false;
    }
}
