package operations;

import java.io.*;
import java.sql.*;
import java.util.*;
import database.*;
import colors.*;

public class RemoveCustomer {
    public static void removeCustomer() {
        Scanner sc = new Scanner(System.in);

        int customerId;
        try{
            System.out.println(C.fCyan + "Enter Customer ID : " + C.reset);
            customerId = sc.nextInt();
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Customer ID (Int ONLY) !!!" + C.reset);
            return;
        }

        try (Connection customerConn = CustomerDatabase.getConnection();
            Statement stmt = customerConn.createStatement()) {

            long mob =0;
            String customerQuery = "SELECT * FROM customer WHERE customerID = " + customerId;
            ResultSet rs = stmt.executeQuery(customerQuery);
            if (rs.next()) {
                String fullName = rs.getString("firstname") + " " + rs.getString("lastname");
                String connectionType = rs.getString("connectionType");
                int rebate = 0;
                mob = rs.getLong("mobile_number");

                switch (connectionType) {
                    case "14.2kg":
                        rebate = 2215;
                        break;
                    case "19kg":
                        rebate = 3000;
                        break;
                    case "5kg":
                        rebate = 1300;
                        break;
                }

                customerConn.setAutoCommit(false);

                String deleteQuery = "DELETE FROM customer WHERE customerID = " + customerId;
                stmt.executeUpdate(deleteQuery);

                System.out.println(C.fMagenta + "Are you sure to Delete Mobile Number? " + C.reset);
                System.out.println(C.fMagenta + "[Press 1 To YES or Press any other number for No]" + C.reset);
                System.out.println();
                System.out.println(C.fCyan + "Enter Your Choice : " + C.reset);
                int ch;

                try{
                    ch = sc.nextInt();
                }
                catch(Exception e){
                    System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Choice (Int ONLY) !!!" + C.reset);
                    return;
                }

                int otp = 0;

                switch(ch){
                case 1 : 

                        System.out.println(C.fGray+ "Enter OTP Which was sent on " + mob + " by Authority : " + C.reset);
                       
                        try{
                            otp = sc.nextInt();
                        }
                        catch(Exception e){
                            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at OTP (Int ONLY) !!!" + C.reset);
                            return;
                        }

                        if(otp!=1234){
                            System.out.println(C.bgRed + "OTP is Incorrect !!!!!" + C.reset);
                            System.out.println();
                            System.out.println(C.fMagenta + "Press 1 to Resend OTP" + C.reset);
                            System.out.println(C.fMagenta + "Press Any Digit For Termination" + C.reset);
                            int choice;

                            try{
                                choice = sc.nextInt();
                            }
                            catch(Exception e){
                                System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Choice (Int ONLY) !!!" + C.reset);
                                return;
                            }
                            
                            switch(choice){
                                case 1:
                                    System.out.println(C.fGray + "Enter Latest OTP Which was sent on " + mob + " by Authority : " + C.reset);
                                    try{
                                        otp = sc.nextInt();
                                    }
                                    catch(Exception e){
                                        System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at OTP (Int ONLY) !!!" + C.reset);
                                        return;
                                    }
                                    if(otp!=9090){
                                        System.out.println(C.bgRed + "Incorrect OTP...." + C.reset);
                                        System.out.println(C.fGray + "Process Terminated by Authority" + C.reset);
                                        return;
                                    }
                                    break;
                                default : 
                                    System.out.println(C.fGray + "Process Terminated by Authority" + C.reset); 
                                    return;
                            }
                        }
                        System.out.println(C.fGreen + "OTP Verified!!!!" + C.reset);

                        customerConn.commit();
                        removeCustomerFromFile(customerId);
                        try{
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
                        System.out.println(C.bgWhite + "Take Your Deposite :  Rs. " + rebate + ".00 Only~   "  + C.reset);
                        System.out.println();
                        System.out.println(C.fGreen + "Customer with customer ID " + customerId + " Deleted Successfully" + C.reset);
                                        
                        break;
                default : 
                        System.out.println(C.fGreen + "Rollbacked Successfully" + C.reset);
                        customerConn.rollback();
            }

        }
        else {
            System.out.println(C.bgRed + "Customer not found." + C.reset);
        }

    }
    catch (Exception e) {
        System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
    }
    }

    private static void removeCustomerFromFile(int customerId) {
        try {
            File inputFile = new File("D:/CST_23002171310160_DS_DBMS_JAVA2/gas1/customers.txt");
            File tempFile = new File("temp_customers.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean removeBlock = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Customer ID: " + customerId)) {
                    removeBlock = true;
                }
                else if (line.startsWith("Customer ID: ") && removeBlock) {
                    removeBlock = false;
                }
                
                if (!removeBlock) {
                    writer.write(line + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

        }
        catch (Exception e) {
            System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
        }
    }
}
