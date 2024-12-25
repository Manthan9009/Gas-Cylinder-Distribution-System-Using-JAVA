package warehouse;

import java.sql.*;

import colors.C;
import database.WarehouseDatabase;

public class Warehouse {
    private static final int MAX_CAPACITY_14_2KG = 375;
    private static final int MAX_CAPACITY_19KG = 120;
    private static final int MAX_CAPACITY_5KG = 50;

    public static int filled14_2kg;
    public static int empty14_2kg;
    public static int filled19kg;
    public static int empty19kg;
    public static int filled5kg;
    public static int empty5kg;

    WarehouseDatabase whd;

    public Warehouse(){
        whd = new WarehouseDatabase();
        try (Connection warehouseConn = whd.getConnection()){
            PreparedStatement ps = warehouseConn.prepareStatement("SELECT * FROM warehouse");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                filled14_2kg = rs.getInt(1);
                empty14_2kg = rs.getInt(2);
                filled19kg = rs.getInt(3);
                empty19kg = rs.getInt(4);
                filled5kg = rs.getInt(5);
                empty5kg = rs.getInt(6);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public int getFilled14_2kg() {
        return filled14_2kg;
    }

    public void setFilled14_2kg() {
        this.filled14_2kg = this.filled14_2kg-1;
        updateDatabase("14kg_filled", this.filled14_2kg);

    }

    public int getEmpty14_2kg() {
        return empty14_2kg;
    }

    public void setEmpty14_2kg() {
        this.empty14_2kg = this.empty14_2kg+1;
        updateDatabase("14kg_empty", this.empty14_2kg);
    }

    public int getFilled19kg() {
        return filled19kg;
    }

    public void setFilled19kg() {
        this.filled19kg = this.filled19kg-1;
        updateDatabase("19kg_filled", this.filled19kg);
    }

    public int getEmpty19kg() {
        return empty19kg;
    }

    public void setEmpty19kg() {
        this.empty19kg = this.empty19kg+1;
        updateDatabase("19kg_empty", this.empty19kg);
    }

    public int getFilled5kg() {
        return filled5kg;
    }

    public void setFilled5kg() {
        this.filled5kg = this.filled5kg-1;
        updateDatabase("5kg_filled", this.filled5kg);
    }

    public int getEmpty5kg() {
        return empty5kg;
    }

    public void setEmpty5kg() {
        this.empty5kg = this.empty5kg+1;
        updateDatabase("5kg_empty", this.empty5kg);
    }

    public void displayStock() {
        System.out.println(C.bgBlue + "            Warehouse Stock            " + C.reset);
        System.out.println(C.bgWhite + "14.2kg Cylinders - Filled: " + filled14_2kg + ", Empty: " + empty14_2kg + C.reset);
        System.out.println(C.bgWhite + "19kg Cylinders - Filled: " + filled19kg + ", Empty: " + empty19kg + C.reset);
        System.out.println(C.bgWhite + "5kg Cylinders - Filled: " + filled5kg + ", Empty: " + empty5kg + C.reset);
    }


    public void setTruckFilled14_2kg(int filled14_2kg) {
        this.filled14_2kg = filled14_2kg;
        updateDatabase("14kg_filled", this.filled14_2kg);
    }
    
    public void setTruckEmpty14_2kg(int empty14_2kg) {
        this.empty14_2kg = empty14_2kg;
        updateDatabase("14kg_empty", this.empty14_2kg);
    }

    public void setTruckFilled19kg(int filled19kg) {
        this.filled19kg = filled19kg;
        updateDatabase("19kg_filled", this.filled19kg);
    }

    public void setTruckEmpty19kg(int empty19kg) {
        this.empty19kg = empty19kg;
        updateDatabase("19kg_empty", this.empty19kg);
    }

    public void setTruckFilled5kg(int filled5kg) {
        this.filled5kg = filled5kg;
        updateDatabase("5kg_filled", this.filled5kg);
    }
    
    public void setTruckEmpty5kg(int empty5kg) {
        this.empty5kg = empty5kg;
        updateDatabase("5kg_empty", this.empty5kg);
    }
    
    public void updateDatabase(String column, int value) {
        try (Connection connection = WarehouseDatabase.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "UPDATE warehouse SET " + column + " = " + value;
            statement.executeUpdate(sql);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
