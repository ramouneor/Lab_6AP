import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/uniportdata";
        Connection myConn = null;
        PreparedStatement p = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            myConn = DriverManager.getConnection(url, "root", "roberts");

            if (myConn != null) {
                JOptionPane.showMessageDialog(null, "Connected to Local Server", "JDBC Connection Status",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            String sql = "select * from user";
            p = myConn.prepareStatement(sql);
            // s = myConn.createStatement();
            rs = p.executeQuery();
            while (rs.next()) {
                String id = rs.getString("idNumber");
                System.out.println(id);
            }
            // String id = rs.getString("idNumber");

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
