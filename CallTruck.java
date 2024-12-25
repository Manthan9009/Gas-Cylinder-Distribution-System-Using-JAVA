package operations;

import java.util.Scanner;
import warehouse.Warehouse;
import main.Main;
import colors.*;

public class CallTruck {
    public static void callTruck() {
        Scanner sc = new Scanner(System.in);
        Warehouse warehouse = Main.warehouse;

        System.out.println(C.bgBlue + " Book Truck Portal " + C.reset);
        System.out.println();
        System.out.println(C.bgYellow + "Here some Suggetions By Quantity : " + C.reset);
        System.out.println(C.bgYellow + "                                   " + C.reset);
        System.out.println(C.bgYellow + "14.2kg = 340 , 19kg = 0, 5kg = 0   " + C.reset);
        System.out.println(C.bgYellow + "14.2kg = 292 , 19kg = 20, 5kg = 20 " + C.reset);
        System.out.println(C.bgYellow + "14.2kg = 286 , 19kg = 40, 5kg = 0  " + C.reset);
        System.out.println();

        int num14_2kg;
        try{
            System.out.println(C.fCyan + "Enter number of 14.2kg cylinders:" + C.reset);
            num14_2kg = sc.nextInt();
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at 14.2kg count Insertion (Int ONLY) !!!" + C.reset);
            return;
        }

        int num19kg;
        try{
            System.out.println(C.fCyan + "Enter number of 19kg cylinders:" + C.reset);
            num19kg = sc.nextInt();
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at 19kg count Insertion (Int ONLY) !!!" + C.reset);
            return;
        }

        int num5kg;
        try{
            System.out.println(C.fCyan + "Enter number of 5kg cylinders:" + C.reset);
            num5kg = sc.nextInt();
        }
        catch(Exception e){
            System.out.println(C.fRed + "ERROR : " + C.bgRed + "Input Mismatch at 5kg count Insertion (Int ONLY) !!!" + C.reset);
            return;
        }

        double totalWeight = num14_2kg * (14.2+15.2) + num19kg * (19+19) + num5kg * (5+7.2);

        System.out.println();
        System.out.println(C.fMagenta + "Total Weight of Cylinders = " + totalWeight + " Kgs " + C.reset);
        System.out.println();

        if (totalWeight > 10000) {
            System.out.println(C.bgRed + "[Over weighted] A Truck can Carry total Maximum 10000kg weight." + C.reset);
            return;
        }

        if (totalWeight < 6000) {
            System.out.println(C.bgRed + "[Under weighted] Minimum Weight should be 6000kg." + C.reset);
            return;
        }

        if(num14_2kg > Main.warehouse.getEmpty14_2kg() || num19kg>warehouse.getEmpty19kg() || num5kg>warehouse.getEmpty5kg()){
            System.out.println(C.bgRed + "Warehoue is full !!!!!" + C.reset);
            return;
        }

        int totalCost = num14_2kg * 842 + num19kg * 1462 + num5kg * 361;

        warehouse.setTruckFilled14_2kg(warehouse.getFilled14_2kg() + num14_2kg);
        warehouse.setTruckFilled19kg(warehouse.getFilled19kg() + num19kg);
        warehouse.setTruckFilled5kg(warehouse.getFilled5kg() + num5kg);
        warehouse.setTruckEmpty14_2kg(warehouse.getEmpty14_2kg() - num14_2kg);
        warehouse.setTruckEmpty19kg(warehouse.getEmpty19kg() - num19kg);
        warehouse.setTruckEmpty5kg(warehouse.getEmpty5kg() - num5kg);

        System.out.println(C.bgWhite + "   Receipt  :  " + C.reset);
        System.out.println(C.bgWhite + "  14.2kg Cylinders: " + num14_2kg +"   " +  C.reset);
        System.out.println(C.bgWhite + "  19kg Cylinders: " + num19kg + "   " + C.reset);
        System.out.println(C.bgWhite + "  5kg Cylinders: " + num5kg + "   " + C.reset);
        System.out.println(C.bgWhite + "                                         " + C.reset);
        System.out.println(C.bgWhite + "  Total Cost: " + totalCost + " Rs.  Only~     "+ C.reset);
        System.out.println();
    }
}