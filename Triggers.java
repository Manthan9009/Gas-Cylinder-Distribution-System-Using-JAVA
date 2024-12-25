package database;

import java.sql.*;
import java.sql.DriverManager;

public class Triggers {
    public static CustomerDatabase csd = new CustomerDatabase();
    static{
        try (Connection customerConn = csd.getConnection()){
            Statement st = customerConn.createStatement();
        String insertTrigger = "CREATE TRIGGER IF NOT EXISTS insert_Trigg " +
                                    "AFTER INSERT ON customer " +
                                    "FOR EACH ROW " +
                                    "BEGIN " +
                                    "insert into customer_audit (action, customerId, firstname, lastname, new_mobile_number , connectionType, execution_time) values ('INSERT', new.customerID, new.firstname, new.lastname, new.mobile_number, new.connectionType, current_timestamp);" + 
                                    " END;";
        
        String updateTrigger = "CREATE TRIGGER IF NOT EXISTS update_Trigg " +
                                    "AFTER UPDATE ON customer " +
                                    "FOR EACH ROW " +
                                    "BEGIN " +
                                    "insert into customer_audit (action, customerId, firstname, lastname, old_mobile_number, new_mobile_number , connectionType, execution_time) values ('UPDATE', old.customerID, old.firstname, old.lastname, old.mobile_number, new.mobile_number, old.connectionType, current_timestamp);" + 
                                    " END;";

        String removeTrigger = "CREATE TRIGGER IF NOT EXISTS remove_Trigg " +
                                    "AFTER DELETE ON customer " +
                                    "FOR EACH ROW " +
                                    "BEGIN " +
                                    "insert into customer_audit (action, customerId, firstname, lastname, old_mobile_number , connectionType, execution_time) values ('DELETE', old.customerID, old.firstname, old.lastname, old.mobile_number, old.connectionType, current_timestamp);" + 
                                    " END;";

        st.executeUpdate(insertTrigger);
        st.executeUpdate(updateTrigger);
        st.executeUpdate(removeTrigger);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
