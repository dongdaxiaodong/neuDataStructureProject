import java.sql.*;
public class database {
    public static void main(String[] args){
        Connection c = null;
        Statement stmt=null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:system.db");


            System.out.println("Opened database successfully");
            stmt=c.createStatement();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }





    }

}
