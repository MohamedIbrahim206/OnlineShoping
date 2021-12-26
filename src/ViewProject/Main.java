package ViewProject;

import java.util.Scanner;

public class Main {
    static boolean getOut = false;

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String input;
        while (!getOut){
            System.out.println("are you the admin or customer? ");
            input = in.next().toLowerCase();
            if (input.equals("admin"))
                AdminsView.main(null);
            else if (input.equals("customer"))
                CustomersView.main(null);
            else
                getOut = true;
        }
    }
}
