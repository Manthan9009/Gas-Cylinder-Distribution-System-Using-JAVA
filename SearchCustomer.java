package operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import colors.*;

import database.*;

public class SearchCustomer {

    static CustomerDatabase csd;
    public SearchCustomer(){
        csd = new CustomerDatabase();
    }

    public static void searchCustomer(){
        Scanner sc = new Scanner(System.in);

        System.out.println(C.fMagenta + "Press 1. To fetch customer by Customer ID" + C.reset);
        System.out.println(C.fMagenta + "Press 2. To fetch customer by Customer's Full Name" + C.reset);
        System.out.println();
        System.out.println(C.fCyan + "Enter your choice : " + C.reset);
        int ch;
        try{
            ch = sc.nextInt();    
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Choice (Int ONLY) !!!" + C.reset);
            return;
        }
        System.out.println();

        switch(ch){
            case 1 : 

                    try (Connection customerConn = csd.getConnection()){
                        PreparedStatement ps = customerConn.prepareStatement("SELECT * FROM customer WHERE customerID = ?");
            
                        System.out.println(C.fCyan + "Enter Customer ID to search : " + C.reset);

                        try{
                            ps.setInt(1, sc.nextInt());
                        }
                        catch(Exception e){
                            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Customer ID (Int ONLY) !!!" + C.reset);
                            return;
                        }
            
                        ResultSet rs = ps.executeQuery();

                        try {
                            System.out.println();
                            System.out.print(C.fGray + "PROCESSING YOUR REQUEST ." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                System.out.println();
                        }
                        catch (Exception e) {
                            System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
                        }
            
                        if(!rs.isBeforeFirst()){
                            System.out.println(C.bgRed + "This Customer doesn't exist in database !!!!!" + C.reset);
                            return;
                        }
            
                        while(rs.next()){
                            System.out.println();
                            System.out.println(C.bgBlue + "       ******* Customer Details ********       " + C.reset);
                            System.out.println(C.bgYellow + "Customer ID                 : " + rs.getInt(1) + "  " + C.reset);
                            System.out.println(C.bgYellow + "Customer's Name             : " + rs.getString(2) + " " + rs.getString(3) + "  " +C.reset);
                            System.out.println(C.bgYellow + "Customer's DOB              : " + rs.getString("dateofbirth") + "  " +C.reset);
                            System.out.println(C.bgYellow + "Customer's Aadhar Number    : " + rs.getLong(5) + "  " +C.reset);
                            System.out.println(C.bgYellow + "Customer's Mobile Number    : " + rs.getLong(6) + "  " +C.reset);
                            System.out.println(C.bgYellow + "Customer's Connection Type  : " + rs.getString(7) + "  " +C.reset);
                        }
                    }
                    catch(Exception e){
                        System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
                    }

                break;

            case 2 : 

                    try (Connection customerConn = csd.getConnection()){
                        PreparedStatement ps = customerConn.prepareStatement("SELECT * FROM customer WHERE firstname LIKE ? AND lastname LIKE ?");
            
                        try{
                            System.out.println(C.fCyan + "Enter First Name of Customer to search : " + C.reset);
                            ps.setString(1, sc.next());                
                        }
                        catch(Exception e){
                            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at First Name (String ONLY) !!!" + C.reset);
                            return;
                        }
            
                        try{
                            System.out.println(C.fCyan + "Enter Last Name of Customer to search : " + C.reset);
                            ps.setString(2, sc.next());
                        }
                        catch(Exception e){
                            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Last Name (String ONLY) !!!" + C.reset);
                            return;
                        }
            
                        ResultSet rs = ps.executeQuery();

                        try {
                            System.out.println();
                            System.out.print(C.fGray + "PROCESSING YOUR REQUEST ." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                Thread.sleep(200);
                                System.out.print(C.fGray + "." + C.reset);
                                System.out.println();
                        }
                        catch (Exception e) {
                            System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
                        }
            
                        if(!rs.isBeforeFirst()){
                            System.out.println(C.bgRed + "This Customer doesn't exist in database !!!!!" + C.reset);
                            return;
                        }
            
                        while(rs.next()){
                            System.out.println();
                            System.out.println(C.bgBlue + "       ******* Customer Details ********       " + C.reset);
                            System.out.println(C.bgYellow + "Customer ID                 : " + rs.getInt(1) + "  " + C.reset);
                            System.out.println(C.bgYellow + "Customer's Name             : " + rs.getString(2) + " " + rs.getString(3) + "  " +C.reset);
                            System.out.println(C.bgYellow + "Customer's DOB              : " + rs.getString("dateofbirth") + "  " +C.reset);
                            System.out.println(C.bgYellow + "Customer's Aadhar Number    : " + rs.getLong(5) + "  " +C.reset);
                            System.out.println(C.bgYellow + "Customer's Mobile Number    : " + rs.getLong(6) + "  " +C.reset);
                            System.out.println(C.bgYellow + "Customer's Connection Type  : " + rs.getString(7) + "  " +C.reset);
                        }
                    }
                    catch(Exception e){
                        System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
                    }

                break;
            
            default : System.out.println(C.bgRed + "Invalid Choice..." + C.reset);
        }
    }
}
