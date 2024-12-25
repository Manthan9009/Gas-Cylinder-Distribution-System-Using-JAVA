package main;

import java.util.Scanner;

import DataStructure.*;
import operations.*;
import warehouse.*;
import database.*;
import colors.*;

public class Main {

    public static Warehouse warehouse = new Warehouse();
    public static Triggers tri = new Triggers();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        LLAadhar ll = new LLAadhar();
        CircularQueueMob cc = new CircularQueueMob();
        int choice;
        
        while (exit !=true) {
            System.out.println();
            System.out.println("  " + C.bgYellow  + "                                              "+C.reset);
            System.out.println(C.bgYellow  + "  "+ C.bgBlue +"            *** Dashboard ***                 " + C.bgYellow  + "  "+ C.reset);
            System.out.println(C.bgYellow  + "  "+ C.bgBlue +"       Press 1. Sell Cylinder                 " + C.bgYellow  + "  "+ C.reset);
            System.out.println(C.bgYellow  + "  "+ C.bgBlue +"       Press 2. Call Truck of Cylinder        " + C.bgYellow  + "  "+ C.reset);
            System.out.println(C.bgYellow  + "  "+ C.bgBlue +"       Press 3. Add Customer                  " + C.bgYellow  + "  "+ C.reset);
            System.out.println(C.bgYellow  + "  "+ C.bgBlue +"       Press 4. Remove Customer               " + C.bgYellow  + "  "+ C.reset);
            System.out.println(C.bgYellow  + "  "+ C.bgBlue +"       Press 5. Update Customer               " + C.bgYellow  + "  "+ C.reset);
            System.out.println(C.bgYellow  + "  "+ C.bgBlue +"       Press 6. Search Customer               " + C.bgYellow  + "  "+ C.reset);
            System.out.println(C.bgYellow  + "  "+ C.bgBlue +"       Press 7. Display Cylinder Stock        " + C.bgYellow  + "  "+ C.reset);
            System.out.println(C.bgYellow  + "  "+ C.bgBlue +"       Press 8. Exit                          " + C.bgYellow  + "  "+ C.reset);
            System.out.println("  " + C.bgYellow  + "                                              "+C.reset);
            System.out.println();
            System.out.print(C.fCyan + "Enter your choice : " + C.reset);

            try{
                choice = sc.nextInt();
                System.out.println();
            }
            catch(Exception e){
                System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Choice (Int ONLY) !!!" + C.reset);
                return;
            }
            
            switch (choice) {
                case 1:
                    SellCylinder.sellCylinder();
                    break;
                case 2:
                    CallTruck.callTruck();
                    break;
                case 3:
                    AddCustomer.addCustomer();
                    break;
                case 4:
                    RemoveCustomer.removeCustomer();
                    break;
                case 5:
                    UpdateCustomer.updateMob();
                    break;
                case 6:
                    SearchCustomer.searchCustomer();
                    break;
                case 7:
                    DisplayStock.displayStock();
                    break;
                case 8:
                    System.out.println(C.fGray + "Exiting......" + C.reset);
                    exit = true;
                    break;
                default:
                    System.out.println(C.bgRed +"Invalid choice."+C.reset);
                    System.out.println(C.fGray +"Please try again....." + C.reset);
            }
        }
    }
}
