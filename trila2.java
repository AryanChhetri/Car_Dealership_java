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
            //creates objects of branch
            
            System.out.println("Closing Connection");
            conn.close();   
        } 
        catch(Exception e){
            System.out.println(e);

        }
        System.out.print("Hello world");
       // Branch b1=new Branch(1, 1, "someplace", "Ahmedabad");
    }
}

