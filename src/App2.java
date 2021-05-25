import java.sql.*;
import java.util.Calendar;

public class App2 {
    public static void main(String[] args) {
        try {
            // create a mysql database connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3301/student", "root", "doggo");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, "Barney");
            preparedStmt.setString(2, "Rubble");
            preparedStmt.setDate(3, startDate);
            preparedStmt.setBoolean(4, false);
            preparedStmt.setInt(5, 5000);

            // execute the preparedstatement
            preparedStmt.execute();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}