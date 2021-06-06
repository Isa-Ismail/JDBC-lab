import java.sql.*;
import java.util.Calendar;

class App2 {
    public static void main(String[] args) {
        try {
            // create a mysql database connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3303/sys", "root", "doggo");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into users (first_name, last_name, date_created, is_admin, salary)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, "Tanvir");
            preparedStmt.setString(2, "Hossain");
            preparedStmt.setDate(3, startDate);
            preparedStmt.setBoolean(4, false);
            preparedStmt.setInt(5, 35000);

            // execute the preparedstatement
            preparedStmt.execute();

            System.out.println("User Created .....");
            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}