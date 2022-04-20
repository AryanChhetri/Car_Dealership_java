import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class trila2 {
    public static void main(String[] args) {
        String jdbcurl="jdbc:postgresql://localhost:5432/dealership";
        String usn="postgres";
        String password="password";
        Statement stmt=null;
        ResultSet rs=null;
        try{
            Connection conn = DriverManager.getConnection(jdbcurl,usn,password);
            System.out.println("Connected to postgres");
            
            //creating and initialising object of branch from psql database
            String query = "select * from Branch";
            stmt = conn.createStatement();
            rs=stmt.executeQuery(query);
            Branch[] b = new Branch[3];
            int i=0; 
            while(rs.next()){
                b[i] = new Branch(Integer.parseInt((rs.getString(1))), Integer.parseInt(rs.getString(2)), rs.getString(3), rs.getString(4));
                i=i+1;
            }
            //branch object created
            
            //c
            query = "select * from GeneralManager";
            rs=stmt.executeQuery(query);
            GeneralManager[] GM = new GeneralManager[3];
            i=0; 
            while(rs.next()){
                GM[i] = new GeneralManager(Integer.parseInt((rs.getString(1))), Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)));
                i=i+1;
            }
            //General Managers created

            //create salesperson object
            query = "select * from salesperson";
            rs=stmt.executeQuery(query);
            Salesperson[] SP = new Salesperson[65];
            i=0; 
            while(rs.next()){
            //array object for cust id preprocessing
            String cid = rs.getString(3);
            int j=0;
            int cida[]=new int[6];
            cid = cid.substring(1,cid.length()-1);
            String [] cid1=cid.split(",");
            for (String a : cid1){
                cida[j]=Integer.parseInt(a);
                j=j+1;
            }
            //preprocessing done
            SP[i] = new Salesperson(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), cida, Float.parseFloat(rs.getString(4)));
            }
            //created salesperson object

            //create accountant object
            query = "select * from accountant";
            rs=stmt.executeQuery(query);
            Accountant[] Acc = new Accountant[10];
            i=0; 
            while(rs.next()){
            //array object for cust id preprocessing
            String cid = rs.getString(3);
            int j=0;
            int cida[]=new int[6];
            cid = cid.substring(1,cid.length()-1);
            String [] cid1=cid.split(",");
            for (String a : cid1){
                cida[j]=Integer.parseInt(a);
                j=j+1;
            }
            //preprocessing done
            Acc[i] = new Accountant(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), cida);            }
            //created accountant
            System.out.println("Closing Connection");
            conn.close();   
        } 
        catch(Exception e){
            System.out.println(e);

        }
        System.out.print("Hello world");
    }
}

