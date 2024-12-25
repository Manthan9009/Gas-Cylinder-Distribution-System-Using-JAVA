package operations;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

import database.*;
import DataStructure.*;
import colors.*;
    
public class AddCustomer {
    static CustomerDatabase csd;

    public AddCustomer(){
        csd = new CustomerDatabase();
    }

    public static void addCustomer() {
        Scanner sc = new Scanner(System.in);

        String firstName;
        try{
            System.out.print(C.fCyan + "Enter First Name : " + C.reset);
            firstName = sc.next();
            System.out.println();
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Firt Name (String ONLY) !!!" + C.reset);
            return;
        }

        String lastName;
        try{
            System.out.print(C.fCyan + "Enter Last Name : " + C.reset);
            lastName = sc.next();
            System.out.println();
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Last Name (String ONLY) !!!" + C.reset);
            return;
        }

        String dob;
        Date birthDate;
        int age;
        try{
            System.out.print(C.fCyan + "Enter Date of Birth (YYYY-MM-DD) : " + C.reset);
            dob = sc.next();
            birthDate = Date.valueOf(dob);
            System.out.println();
            age = calculateAge(birthDate);
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at DOB (Date ONLY) !!!" + C.reset);
            return;
        }

        if (age < 18) {
            System.out.println(C.bgRed + "Customer must be at least 18 years old." + C.reset);
            return;
        }

        long aadharNumber;
        try{
            System.out.print(C.fCyan + "Enter Aadhar Number : " + C.reset);
            aadharNumber = sc.nextLong();
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Aadhar Number (Long ONLY) !!!" + C.reset);
            return;
        }

        if (String.valueOf(aadharNumber).length() != 12) {
            System.out.println(C.bgRed + "Aadhar number must be 12 digits." + C.reset);
            return;
        }
        boolean flag = LLAadhar.aadharChecker(aadharNumber);
        if(flag == true){
            System.out.println(C.bgRed + "Duplicate Aadhar number Detected !!!!!!!!" + C.reset);
            return;
        }
        else{
            System.out.println(C.fGreen + "Aadhar number Verified :)" + C.reset);
            System.out.println();
        }

        long mobileNumber;
        try{
            System.out.print(C.fCyan + "Enter Mobile Number : " + C.reset);
            mobileNumber = sc.nextLong();

        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Mobile Number (Long ONLY) !!!" + C.reset);
            return;
        }

        if (String.valueOf(mobileNumber).length() != 10) {
            System.out.println(C.bgRed + "Mobile number must be 10 digits." + C.reset);
            return;
        }
        boolean flag1 = CircularQueueMob.mobileChecker(mobileNumber);
        if(flag1 == true){
            System.out.println(C.bgRed + "Duplicate Mobile number Detected !!!!!!!!" + C.reset);
            return;
        }
        else{
            int otp = 0;

            System.out.println();
            System.out.print(C.fGray + "Enter OTP Which was sent on " + mobileNumber + " by Authority : " + C.reset);
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
                System.out.println("Press 1 to Resend OTP");
                System.out.println("Press Any Digit For Termination");
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
                        System.out.print(C.fGray + "Enter Latest OTP Which was sent on " + mobileNumber + " by Authority : " + C.reset);
                        otp = sc.nextInt();
                        if(otp!=9090){
                            System.out.println(C.bgRed + "Incorrect OTP...." + C.reset);
                            System.out.println(C.fRed + "Process Terminated by Authority" + C.reset);
                        return;
                        }
                    break;
                    default : 
                            System.out.println(C.fRed + "Process Terminated by Authority" + C.reset); 
                            return;
                    }
            }
            System.out.println(C.fGreen + "OTP Verified!!!!" + C.reset);
            System.out.println();
        }

        String connectionType;
        try{
        System.out.print(C.fCyan + "Enter Type of Connection (14.2kg, 19kg, 5kg) : " + C.reset);
        connectionType = sc.next();
        System.out.println();
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at Choice (Int ONLY) !!!" + C.reset);
            return;
        }

        int depositCharge = 0, refillCharge = 0, adminCharge = 118;
        switch (connectionType) {
            case "14.2kg":
                depositCharge = 2215;
                refillCharge = 915;
                break;
            case "19kg":
                depositCharge = 3000;
                refillCharge = 1612;
                break;
            case "5kg":
                depositCharge = 1300;
                refillCharge = 411;
                break;
            default:
                System.out.println(C.bgRed + "Invalid connection type." + C.reset);
                return;
        }

        int totalCharges = depositCharge + refillCharge + adminCharge;

        try (Connection customerConn = csd.getConnection();
            PreparedStatement ps = customerConn.prepareStatement(
                    "INSERT INTO customer (firstname, lastname, dateofbirth, aadhar_number, mobile_number, connectionType) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setDate(3, birthDate);
            ps.setLong(4, aadharNumber);
            ps.setLong(5, mobileNumber);
            ps.setString(6, connectionType);
            
            customerConn.setAutoCommit(false);

            

            System.out.println(C.fMagenta + "Are you sure to ADD Customer ? " + C.reset);
                    System.out.println(C.fMagenta + "[Press 1 To YES or Press any other number for No]" + C.reset);
                    System.out.print(C.fCyan + "Enter Your Choice : " + C.reset);
                    int ch = sc.nextInt();

                    ps.executeUpdate();
                    switch(ch){
                        case 1 : 
                                
                                customerConn.commit();
                                LLAadhar.addNewAadhar(aadharNumber);
                                CircularQueueMob.addNewMob(mobileNumber);
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
                                try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:/CST_23002171310160_DS_DBMS_JAVA2/gas1/customers.txt", true))) {
                                    writer.write("Customer ID: " + getLastInsertedId(customerConn) + "\n");
                                    writer.write("Name: " + firstName + " " + lastName + "\n");
                                    writer.write("DOB: " + dob + "\n");
                                    writer.write("Aadhar Number: " + aadharNumber + "\n");
                                    writer.write("Mobile Number: " + mobileNumber + "\n");
                                    writer.write("Connection Type: " + connectionType + "\n");
                                    writer.write("Total Charges:  Rs. " + totalCharges + ".00 Only~" +"\n");
                                    writer.write("-------------------------------\n");
                                }
                    
                                System.out.println(C.fGreen + "Customer added successfully." + C.reset);
                                System.out.println();
                                System.out.println(C.bgWhite + " Deposite Charges :  Rs. " + depositCharge + ".00   " + C.reset);
                                System.out.println(C.bgWhite + " Refill Charges :  Rs. " + refillCharge + ".00   " + C.reset);
                                System.out.println(C.bgWhite + " Administrator Charges :  Rs. " + adminCharge + ".00   " + C.reset);
                                System.out.println(C.bgWhite + " --------------------------------" + C.reset);
                                System.out.println(C.bgWhite + " Total Payable :  Rs. " + totalCharges + ".00 Only~   " + C.reset);
                                
                                break;
                        default : 
                                System.out.println(C.fGreen + "Rollbacked Successfully" + C.reset);
                                customerConn.rollback();
                    }

        }
        catch (Exception e) {
            System.out.println(C.bgRed + "An error occurred: " + e.getMessage() + C.reset);
        }
    }

    private static int calculateAge(Date birthDate) {
        long millis = System.currentTimeMillis();
        Date currentDate = new Date(millis);

        long ageInMillis = currentDate.getTime() - birthDate.getTime();
        
        int age = (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
        return age;
    }

    private static int getLastInsertedId(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }
}
