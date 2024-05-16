package ch11;

import java.sql.*;

public class DriverTest {
    public static void main(String[] args) {
        Connection con;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydb?useSSL=true&requireSSL=true&serverTimezone=Asia/Seoul";
            con = DriverManager.getConnection(url, "root", "9290");
            
            System.out.println("Success");
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        }
    }
}
