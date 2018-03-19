package test.springMVC.dao;

import java.sql.*;

/**
 * Created by zouwei on 2018/3/19.
 */
public class LoginDao {
    public static int Login(String userName, String passWord) {

        int loginType = 1;
        Connection conn;

        String driver = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://127.0.0.1:3306/testDemo";

        String user = "root";
        String sqlPassWord = "zw199388";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, sqlPassWord);

            if (!conn.isClosed()) {
                System.out.print("Succeeded connection to the database ");
            }
//            Statement statement = conn.createStatement();
            PreparedStatement p = conn.prepareStatement("select * from userinfo WHERE userName=? and passWord=?");

            p.setString(1, userName);
            p.setInt(2, Integer.parseInt(passWord));
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String username = rs.getString("userName");
                System.out.print("userName = " + username);
                if (username != null && username != "") {
                    loginType = 0;
                }
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginType;
    }
}
