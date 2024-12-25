package operations;

import java.io.*;
import java.sql.*;
import java.util.*;

import DataStructure.*;
import database.*;
import colors.*;

public class UpdateCustomer {

    static CustomerDatabase csd;
    public UpdateCustomer(){
        csd = new CustomerDatabase();
    }

    public static void updateMob(){
        Scanner sc = new Scanner(System.in);

        System.out.println(C.fCyan + "Enter Customer ID to Update : " + C.reset);
        int id;

        try{
            id = sc.nextInt();                 
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Customer ID (Int ONLY) !!!" + C.reset);
            return;
        }

        try (Connection customerConn = csd.getConnection()){
            PreparedStatement ps = customerConn.prepareStatement("Select * from customer where customerID = " + id);
            ResultSet rs = ps.executeQuery();

            if(!rs.isBeforeFirst()){
                System.out.println(C.bgRed + "This Customer ID doesn't exist in database !!!!!" + C.reset);
                return;
            }

            int custID=0;

            while(rs.next()){
                long preMob = rs.getLong(6);
                custID = rs.getInt(1);

                System.out.println(C.fCyan + "Enter new Mobile number : " + C.reset);
                long upMob;

                try{
                    upMob = sc.nextLong();
                }
                catch(Exception e){
                    System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Mobile Number (Long ONLY) !!!" + C.reset);
                    return;
                }

                if(String.valueOf(upMob).length() != 10){
                    System.out.println(C.bgRed + "Mobile number should be Contains Exect 10 digits !!!!!!!" + C.reset);
                    return;
                }
            
                boolean flag1 = CircularQueueMob.mobileChecker(upMob);

                if(flag1 == true){
                    System.out.println(C.bgRed + "Duplicate Mobile number Detected !!!!!!!!" + C.reset);
                    return;
                }
                else{
                    System.out.println(C.fGreen + "Mobile number Verified :)" + C.reset);
                    CircularQueueMob.removeMob(upMob);
                    CircularQueueMob.addNewMob(upMob);

                    customerConn.setAutoCommit(false);

                    PreparedStatement pst = customerConn.prepareStatement("UPDATE customer set mobile_number = " + upMob + " Where customerID = " + id);
                    int r = pst.executeUpdate();
                    System.out.println(C.fMagenta + "Are you sure to Update Mobile number ? " + C.reset);
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
                                System.out.println(C.fGray + "Enter OTP Which was sent on " + upMob + " by Authority : " + C.reset);
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
                                            System.out.println(C.fGray + "Enter Latest OTP Which was sent on " + upMob + " by Authority : " + C.reset);
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
                                updateCustomer(custID,  upMob);
                                customerConn.commit();
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
                                if(r>0){
                                    System.out.println(C.fGreen + "Mobile Numer Updated Successfully" + C.reset);
                                    System.out.println();
                                    System.out.println(C.bgWhite + "     ******* Updated Details ********      " + C.reset);
                                    System.out.println(C.bgWhite + "Customer ID : " + rs.getInt(1) + C.reset);
                                    System.out.println(C.bgWhite + "Customer Name : " + rs.getString(2) + " " + rs.getString(3) + C.reset);
                                    System.out.println(C.bgWhite + "Customer's Previous Mobile Number : " + preMob + C.reset);
                                    System.out.println(C.bgWhite + "Customer's Updated Mobile Number : " + upMob + C.reset);
                                    System.out.println(C.bgWhite + "-----------------------------------------------" + C.reset);
                                    
                                }
                                break;
                        default : 
                                System.out.println(C.fGreen + "Rollbacked Successfully" + C.reset);
                                customerConn.rollback();
                    }

                }
            }
        }
        catch(Exception e){
            System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
        }
    }

    public static void updateCustomer(int customerID, long updatedMob) {
        try {
            File file = new File("D:/CST_23002171310160_DS_DBMS_JAVA2/gas1/customers.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            String customerIdString = "Customer ID: " + customerID;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
                if (line.startsWith(customerIdString)) {
                    for (int i = 0; i < 6; i++) { // Read the next 6 lines
                        line = reader.readLine();
                        if (line.startsWith("Mobile Number: ")) {
                            line = "Mobile Number: " + updatedMob;
                        }
                        content.append(line).append("\n");
                    }
                }
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());
            writer.close();

            System.out.println(C.fGreen + "Mobile number updated successfully for customer ID: " + customerID + C.reset);
        }
        catch (Exception e) {
            System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
        }
    }
}
