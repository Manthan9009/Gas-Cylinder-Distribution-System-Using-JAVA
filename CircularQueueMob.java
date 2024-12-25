package DataStructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.*;

public class CircularQueueMob {
    static int f, r, cap;
    static long[] arr;
    static CustomerDatabase csd;

    public CircularQueueMob(){
        f=-1;
        r=-1;
        cap = 1000;
        arr = new long[cap];

        try (Connection customerConn = csd.getConnection();
             PreparedStatement ps = customerConn.prepareStatement(
             "select mobile_number from customer")){

                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    if((f==r+1) || (f==0 && r==cap-1)){
                        System.out.println();
                    }
                    else{
                        if(f==-1){
                            f=0;
                        }
                        if(r==cap-1){
                            r=0;
                        }
                        else{
                            r=r+1;
                        }
                        arr[r] = rs.getLong(1);
                    }
                }
        }

        catch(Exception e){
           e.printStackTrace();
        }
    }

    public static boolean mobileChecker(long mob){
        if(f==-1){
            return false;
        }
        else if(arr[f]==mob){
            return true;
        }
        else{
            for(int i=f; i<=r; i++){
                if(arr[i]==mob){
                    return true;
                }
            }
        }
        return false;
    }

    public static void addNewMob(long mob){
        if((f==r+1) || (f==0 && r==cap-1)){
            System.out.println();
        }
        else{
            if(f==-1){
                f=0;
            }
            if(r==cap-1){
                r=0;
            }
            else{
                r=r+1;
            }
            arr[r] = mob;
        }
    }

    public static void removeMob(long mob){
        int currentIndex = f;
        boolean found = false;

        for(int i= 0; i<cap; i++){
            if(arr[currentIndex] == mob){
                found = true;
                break;
            }
            currentIndex = (currentIndex+1)%cap;
        }

        for(int i = currentIndex; i!=r; i = (i+1)%cap){
            arr[i] = arr[(i+1)%cap];
        }

        r = (r-1 + cap)% cap;
        cap--;
    }
}
