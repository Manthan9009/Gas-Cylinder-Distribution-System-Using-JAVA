package operations;

import java.sql.*;
import java.util.Scanner;

import colors.C;
import database.*;
import main.Main;
import warehouse.Warehouse;

public class SellCylinder {
    public static void sellCylinder() {
        Scanner sc = new Scanner(System.in);

        int customerId;
        try{
            System.out.print(C.fCyan + "Enter Customer ID : " + C.reset);
            customerId = sc.nextInt();
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Customer ID (Int ONLY) !!!" + C.reset);
            return;
        }
        System.out.println();

        try (Connection customerConn = CustomerDatabase.getConnection();
             Statement customerStmt = customerConn.createStatement()) {

            String customerQuery = "SELECT * FROM customer WHERE customerID = " + customerId;
            ResultSet customerRs = customerStmt.executeQuery(customerQuery);
            if (!customerRs.next()) {
                System.out.println(C.bgRed + "Customer not found." + C.reset);
                return;
            }

            String cylinderType = customerRs.getString("connectionType");

            int sellingPrice = 0;
            switch (cylinderType) {
                case "14.2kg":
                    sellingPrice = 915;
                    break;
                case "19kg":
                    sellingPrice = 1612;
                    break;
                case "5kg":
                    sellingPrice = 411;
                    break;
                default:
                    System.out.println(C.bgRed + "Invalid cylinder type."  + C.reset);
                    return;
            }
    


            Warehouse warehouse = Main.warehouse;
            int filledCylinders = 0;
            switch (cylinderType) {
                case "14.2kg":
                    filledCylinders = warehouse.getFilled14_2kg();
                    if (filledCylinders > 0) {
                        warehouse.setFilled14_2kg();
                        warehouse.setEmpty14_2kg();
                    } else {
                        System.out.println("14.2kg cylinder is out of stock.");
                        return;
                    }
                    break;
                case "19kg":
                    filledCylinders = warehouse.getFilled19kg();
                    if (filledCylinders > 0) {
                        warehouse.setFilled19kg();
                        warehouse.setEmpty19kg();
                    } else {
                        System.out.println("19kg cylinder is out of stock.");
                        return;
                    }
                    break;
                case "5kg":
                    filledCylinders = warehouse.getFilled5kg();
                    if (filledCylinders > 0) {
                        warehouse.setFilled5kg();
                        warehouse.setEmpty5kg();
                    } else {
                        System.out.println("5kg cylinder is out of stock.");
                        return;
                    }
                    break;
            }

        try {
            System.out.println();
            System.out.print(C.fGray + "PROCESSING YOUR REQUEST ." + C.reset);
                                Thread.sleep(300);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(300);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(300);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(300);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(300);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(300);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(300);
                                System.out.print(C.fGray + "." + C.reset);
                                System.out.println();
        }
        catch (Exception e) {
            System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
        }
        
        String customerName = customerRs.getString("firstname") + " " + customerRs.getString("lastname");

        System.out.println(C.bgWhite + " Receipt :  ");
        System.out.println(C.bgWhite + " Customer ID: " + customerId + "   " + C.reset);
        System.out.println(C.bgWhite + " Customer Name: " + customerName + "   " + C.reset);
        System.out.println(C.bgWhite + " Cylinder Type: " + cylinderType + "   " + C.reset);
        System.out.println();
        System.out.println(C.bgWhite + " Total Cost :  Rs. " + sellingPrice  + ".00 Only~   " + C.reset);

        }
        catch (Exception e) {
            System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
        }
    }
}