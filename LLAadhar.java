package DataStructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.*;

public class LLAadhar {
    public static class Node{
        long data;
        Node next;

        Node(long data){
            this.data = data;
            this.next = null;
        }
    }
    
    static Node first = null;

    static CustomerDatabase csd;

    public LLAadhar(){
        
    try (Connection customerConn = csd.getConnection();
        PreparedStatement ps = customerConn.prepareStatement(
             "select aadhar_number from customer")){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Node n = new Node(rs.getLong(1));
                    if(first == null){
                        first = n;
                        first.next = null;
                    }
                    else {
                        Node dummy = first;
                        while(dummy.next!=null){
                            dummy = dummy.next;
                        }

                        dummy.next = n;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //Linkedlist
    public static boolean aadharChecker(long aadharNumber){
        if(first==null){
            return false;
        }
        else if(first.data == aadharNumber){
            return true;
        }
        else{
            Node dummy = first;

            while(dummy!=null){
                if(dummy.data == aadharNumber){
                    return true;
                }
                dummy = dummy.next;
            }
        }
        return false;
    }

    public static void addNewAadhar(long aadharNumber){
        Node a = new Node(aadharNumber);
        if(first == null){
            first = a;
            first.next = null;
        }
        else {
            Node dummy = first;
            while(dummy.next!=null){
                dummy = dummy.next;
            }
            dummy.next = a;
        }
    }
}