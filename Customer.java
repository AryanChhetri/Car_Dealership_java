import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;



class customer{
    
    private String address,name;
    private int custid;
    public int empid;
    double budget;
    private long phnum;
    public int b_id;
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public customer(String name,String address,double budget,int b_id, long phnum){
        this.address=address;
        this.phnum=phnum;
        this.name=name;
        this.budget=budget;
        this.b_id=b_id;
    }
    
    // public choose_employee(){

    // }

    // public view_vehicles(){

    // }

    // public request_quotation(){

    // }

    // public rate_employee(){

    // }

    // public buy_loan(){

    // }

    //choose employee(here he will see list of employee and chose an employee)
    //purchase(vehicle veh, boolean finance)
    //pricenegotiate will be within purchase
    //feedback()
    //repayloan()

    public static void main(String args[]){
        System.out.println("hello world");
        // customer c1=new customer("Aryan","1232 hauz khas",12000,1);
        String jdbcurl="jdbc:postgresql://localhost:5432/dealership";
        String usn="postgres";
        String password="password";
        try{
        Connection conn=DriverManager.getConnection(jdbcurl,usn,password);
        System.out.println("Connected to Postgres");
        conn.close();
        } catch(SQLException e) {
            System.out.println("Error couldnt connect to database");
                e.printStackTrace();
        }

    }
}

// public class trial{
//     public static void main(String[] args){
//         System.out.println("hello world");
//         customer c1=new customer("Aryan","1232 hauz khas",12000,1);
//         String jdbcurl="jdbc:postgresql://localhost:5432/dealership";
//         String usn="postgres";
//         String password="password";
//         try{
//         Connection conn=DriverManager.getConnection(jdbcurl,usn,password);
//         System.out.println("Connected to Postgres");
//         conn.close();
//         } catch(SQLException e) {
//             System.out.println("Error couldnt connect to database");
//                 e.printStackTrace();
//         }
// }
// }