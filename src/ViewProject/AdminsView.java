package ViewProject;

import BAOProject.BaoFactoryPro;
import BAOProject.WarehouseInter;
import DTOProject.Admins;
import DTOProject.Departments;
import java.util.Scanner;

public class AdminsView {
   static boolean getOut = false;

    // it's very wrong
    private static final String userName1, Password1;
    static {
        userName1 = "Mohammed";
        Password1 = "Mo1020h$";
    }
    private static final String userName2, Password2;
    static {
        userName2 = "Mostafa";
        Password2 = "Mo3040h$";
    }

    private static WarehouseInter business = new BaoFactoryPro().getClassBao();
    public WarehouseInter getBusiness() {
        return business;
    }

    public static void main(String []args){
        AdminsView av1 = new AdminsView();
        Admins a1 = new Admins();
        Scanner input = new Scanner(System.in);
        String Username , password;

        while (true){
            System.out.println("Please Enter your username : ");
            Username = input.next();
            if(Username.equals(userName1) || Username.equals(userName2))
                break;
            else
                System.out.println("username is incorrect , please try again");
        }
        while (true){
            System.out.println("please Enter your password : ");
            password = input.next();
            if(password.equals(Password1) || password.equals(Password2))
                break;
            else
                System.out.println("password is incorrect , please try again");
        }
        Admins manager = a1.getAccess(Username , password);

        while (!av1.getOut){
            printList();
            doAction(manager , input.nextInt());
        }
        av1.getOut = false;
    }

    static void printList(){
        System.out.println("1- view departments");
        System.out.println("2- add product");
        System.out.println("3- delete product");
        System.out.println("4- modify product");
        System.out.println("5- to go back ");
    }

    static void doAction(Admins a , int i){
        AdminsView av1 = new AdminsView();
        Departments product = new Departments();
        Scanner in = new Scanner(System.in);
        switch (i){
            case 1:
                printDeparts();
                break;

            case 2:
                System.out.println("please enter the product's name :");
                product.setName(in.next());
                System.out.println("please enter the product's price per amount :");
                product.setPrice(in.nextFloat());
                System.out.println("please enter the product's amount :");
                System.out.println("is it countable? (Y/N)");
                String result = in.next();
                int am;
                float amo;
                if(result.toLowerCase().equals("y")){
                    System.out.println("please enter how many ?");
                    am = in.nextInt();
                    business.addProduct(a , product.getName() , am , product.getPrice());
                }
                else {
                    System.out.println("please enter how much ?");
                    amo = in.nextFloat();
                    business.addProduct(a , product.getName(), amo , product.getPrice());
                }
                break;
            case 3:
                System.out.println("please enter product's id :");
                business.deleteProduct(a , in.nextInt());
                break;

            case 4:
                System.out.println("please enter product's id that you want modify :");
                product.setId(in.nextInt());
                System.out.println("please enter the new name :");
                product.setName(in.next());
                System.out.println("please enter the new price :");
                product.setPrice(in.nextFloat());
                System.out.println("is it countable ? (Y/N)");
                String res = in.next();
                if(res.toLowerCase().equals("y")){
                    System.out.println("please enter how many ?");
                    am = in.nextInt();
                    business.modifyProduct(a, product.getId(), product.getName(), am , product.getPrice());
                }
                else{
                    System.out.println("please enter how much ?");
                    amo = in.nextFloat();
                    business.modifyProduct(a , product.getId(), product.getName(), amo , product.getPrice());
                }
                break;

            default:
                av1.getOut = true;
                break;
        }
    }
    static void printDeparts(){
        AdminsView av1 = new AdminsView();
        Departments product = new Departments();
        Scanner in = new Scanner(System.in);

        System.out.println("1- Vegetables");
        System.out.println("2- Meats");
        System.out.println("3- Legumes");
        System.out.println("4- DiartyProducts");


    }
}
