import java.sql.*;

class App extends Thread {

    public static void main(String args[]) {
        int sleep = 50;
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3301/sys", "root", "doggo");

            Statement stmt = con.createStatement();
            String query = "select * from football_clubs";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n" + "\n");

            System.out.println("CLUB_ID" + "        " + "CLUB_NAME" + "        " + "COUNTRY" + "        "
                    + "UCL_TROPHIES" + "        " + "COLOR" + "\n");

            while (rs.next()) {
                try {
                    Thread.sleep(sleep += 150);
                    System.out.println(rs.getInt(1) + "              " + rs.getString(2) + "        " + rs.getString(3)
                            + "              " + rs.getInt(4) + "               " + rs.getString(5) + "\n");
                } catch (Exception e) {
                }

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
