package ViewProject;

import BAOProject.BaoFactoryPro;
import BAOProject.WarehouseInter;
import BAOProject.departmentsEnum;
import DTOProject.Admins;
import DTOProject.product;
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

    public static void main(String[] args) {
        AdminsView av1 = new AdminsView();
        Admins a1 = new Admins();
        Scanner input = new Scanner(System.in);
        String Username, password;

        printProducts();

        while (true) {
            System.out.println("Please Enter your username : ");
            Username = input.next();
            if (Username.equals(userName1) || Username.equals(userName2))
                break;
            else
                System.out.println("username is incorrect , please try again");
        }
        while (true) {
            System.out.println("please Enter your password : ");
            password = input.next();
            if (password.equals(Password1) || password.equals(Password2))
                break;
            else
                System.out.println("password is incorrect , please try again");
        }
        Admins manager = a1.getAccess(Username, password);

        while (!av1.getOut) {
            printList();
            doAction(manager, input.nextInt());
        }
        av1.getOut = false;
    }

    static void printList() {
        System.out.println("1- view departments");
        System.out.println("2- add product");
        System.out.println("3- delete product");
        System.out.println("4- modify product");
        System.out.println("5- to go back ");
    }

    static void doAction(Admins a, int i) {
        AdminsView av1 = new AdminsView();
        product product = new product();
        Scanner in = new Scanner(System.in);
        switch (i) {
            case 1:
                business.viewDepartments();
                while (true) {
                    System.out.println("What's department you want (Enter number)");
                    int y = in.nextInt();
                    // Exception handling here
                    if (y == 1) {
                        business.viewProducts(departmentsEnum.Meats);
                        break;
                    }
                    else if (y == 2) {
                        business.viewProducts(departmentsEnum.Legumes);
                        break;
                    }
                    else if (y == 3) {
                        business.viewProducts(departmentsEnum.DiartyProducts);
                        break;
                    }
                    else if (y == 4) {
                        business.viewProducts(departmentsEnum.Vegetables);
                        break;
                    }
                    else
                        System.out.println("incorrect input , please inter correct input ");
                }
                break;

            case 2:
                business.viewDepartments();
                System.out.println("please enter the department's number that you want add inside it ");
                int any = in.nextInt();
                System.out.println("please enter the product's name :");
                product.setName(in.next());
                System.out.println("please enter the product's price per amount :");
                product.setPrice(in.nextFloat());
                System.out.println("please enter the product's amount :");
                System.out.println("is it countable? (Y/N)");
                String result = in.next();
                int am;
                float amo;
                if (result.toLowerCase().equals("y")) {
                    System.out.println("please enter how many ?");
                    am = in.nextInt();
                    // I want to add in department that user inter it.
                    business.addProduct(a , product.getName() , am , product.getPrice() , business.getDepartment(any));
                } else {
                    System.out.println("please enter how much ?");
                    amo = in.nextFloat();
                    business.addProduct(a , product.getName(), amo , product.getPrice() , business.getDepartment(any));
                }
                break;
            case 3:
                business.viewDepartments();
                System.out.println("please enter departments' name that you want delete from it ");
                //business.deleteProduct(a , in.next() , );
                break;

            case 4:
                business.viewDepartments();
                System.out.println("please enter departments' name that you want modify from it ");
                printProducts();
                System.out.println("please enter product's id that you want modify :");
                product.setId(in.nextInt());
                System.out.println("please enter the new name :");
                product.setName(in.next());
                System.out.println("please enter the new price :");
                product.setPrice(in.nextFloat());
                System.out.println("is it countable ? (Y/N)");
                String res = in.next();
                if (res.toLowerCase().equals("y")) {
                    System.out.println("please enter how many ?");
                    am = in.nextInt();
                    //business.modifyProduct(a, product.getId(), product.getName(), am , product.getPrice());
                } else {
                    System.out.println("please enter how much ?");
                    amo = in.nextFloat();
                    //business.modifyProduct(a , product.getId(), product.getName(), amo , product.getPrice());
                }
                break;

            default:
                av1.getOut = true;
                break;
        }
    }

    static void printProducts() {
        Admins a1 = new Admins();
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Tomato", 20, 4, departmentsEnum.Vegetables);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Carrot", 10, 5, departmentsEnum.Vegetables);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Beans", 25, 12, departmentsEnum.Vegetables);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Potatos", 15, 6, departmentsEnum.Vegetables);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Cucumber", 13, 5, departmentsEnum.Vegetables);

        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Chicken", 5, 35, departmentsEnum.Meats);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Fish", 10, 30, departmentsEnum.Meats);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Meats", 25, 130, departmentsEnum.Meats);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Luncheon", 15, 40, departmentsEnum.Meats);

        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Rice", 50, 9, departmentsEnum.Legumes);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Macaroni", 40, 6.5f, departmentsEnum.Legumes);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Sugar", 25, 8, departmentsEnum.Legumes);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Salt", 30, 2, departmentsEnum.Legumes);

        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Milk", 8, 12, departmentsEnum.DiartyProducts);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Cheese", 10, 15, departmentsEnum.DiartyProducts);
        business.addProduct(a1.getAccess("Mohammed", "Mo1020h$"), "Yogurt", 20, 2, departmentsEnum.DiartyProducts);

    }

}
