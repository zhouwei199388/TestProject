package test.springMVC.dao;

import java.sql.*;

/**
 * Created by zouwei on 2018/3/19.
 */
public class LoginDao {
    public static int Login(String userName, String passWord) {
        int loginType = 1;
        Connection conn;

        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.url, ConnectionMessage.user, ConnectionMessage.sqlPassWord);
            if (!conn.isClosed()) {
                System.out.print("Succeeded connection to the database ");
            }
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
