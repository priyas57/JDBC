import java.sql.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class curdOperation {
    public static void selectQuery()throws ClassNotFoundException, SQLException {
        String url="jdbc:mysql://localhost:3306/bank";
        String username="root";
        String password="root";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(url,username,password);
        System.out.println("Connection object created");
        Statement s=con.createStatement();

        ResultSet rs=s.executeQuery("select * from customer");
        while(rs.next()){
            System.out.println(rs.getString("c_name")+" "+rs.getString("accno")+" "+" "+rs.getInt("pin")+" " +
                    rs.getInt("balance")+" "+rs.getString("pan")+" "+rs.getString("acc_type")
            +" "+ rs.getString("contactno")+" "+rs.getString("customer_addr")+" "+rs.getInt("b_id"));
        }

    }

    public static void insertQuery(String c_name,String accno,int pin,int balance,String pan,String acc_type,String contactno,String customer_addr,int b_id)throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");//driver classloading
        Connection con = DriverManager.getConnection(url, username, password);//connection object creation
        //Statement s=con.createStatement();
        //int row= s.executeUpdate("insert into branch values("+id+",'"+branch+"','"+address+"');");
        PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");
        ps.setString(1, c_name);
        ps.setString(2, accno);
        ps.setInt(3, pin);
        ps.setInt(4,balance);
        ps.setString(5,pan);
        ps.setString(6,acc_type);
        ps.setString(7,contactno);
        ps.setString(8,customer_addr);
        ps.setInt(9,b_id);

        int row = ps.executeUpdate();
        if (row > 0) {
            System.out.println("values inserted successfully");
        } else {
            System.out.println("values not inserted");
        }
    }
    public static void updatecustomer(int id,String contactno,int pin)throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");//driver classloading
        Connection con = DriverManager.getConnection(url, username, password);//connection object creation
//        Statement s=con.createStatement();
//        int row= s.executeUpdate("insert into branch values("+id+",'"+branch+"','"+address+"');");
        PreparedStatement ps = con.prepareStatement("update customer set pin=?,contactno=?  where b_id=?;");
        ps.setInt(1,pin);
        ps.setString(2, contactno);
        ps.setInt(3,id);
        int row = ps.executeUpdate();
        if (row > 0) {
            System.out.println("values updated successfully");
        } else {
            System.out.println("values not updated");
        }
    }
    public static void delete(int id)throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");//driver classloading
        Connection con = DriverManager.getConnection(url, username, password);//connection object creation
//        Statement s=con.createStatement();
//        int row= s.executeUpdate("insert into branch values("+id+",'"+branch+"','"+address+"');");
        PreparedStatement ps = con.prepareStatement("delete from customer where b_id=?");
        ps.setInt(1, id);
        int row = ps.executeUpdate();
        if (row > 0) {
            System.out.println("values deleted successfully");
        } else {
            System.out.println("values not deleted");
        }
    }
    public static void main(String[] args) throws ClassNotFoundException,SQLException {

//        selectQuery();

       Scanner sc=new Scanner(System.in);
        System.out.println("enter the name ");
        String c_name=sc.nextLine();
        System.out.println("enter the accno");
        String accno=sc.nextLine();
        System.out.println("enter the pin ");
        int pin=sc.nextInt();
        System.out.println("enter the balance ");
        int balance=sc.nextInt();
        System.out.println("enter the pan");
        String pan=sc.next();
        System.out.println("enter the acc_type ");
        String acc_type= sc.next();
        System.out.println("enter the contactno");
        String contactno=sc.next();
        System.out.println("enter the customer_addr ");
        String customer_addr= sc.next();
        System.out.println("enter the b_id");
        int b_id=sc.nextInt();
        insertQuery(c_name,accno,pin,balance,pan,acc_type, contactno,customer_addr,b_id);

        //selectQuery();
       // Scanner sc=new Scanner(System.in);
        //System.out.println("enter the id ");
        //int id=sc.nextInt();
        //System.out.println("enter the contactno ");
        //String contactno= sc.next();
        //System.out.println("enter the pin ");
        //int pin= sc.nextInt();
        //updatecustomer(id,contactno,pin);
        //selectQuery();


        //Scanner sc=new Scanner(System.in);
        //System.out.println("enter the id ");
        //int b_id=sc.nextInt();
        //delete(b_id);
        //selectQuery();
    }

}

