package test.springMVC.dao;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zouwei on 2018/3/20.
 */
@Repository
public class RegisterDao {

    public int register(String userName, String passWord) {
        int registerType = 1;
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.url, ConnectionMessage.user, ConnectionMessage.sqlPassWord);
            if (!conn.isClosed()) {
                System.out.print("Succeeded connection to the database ");
            }
            PreparedStatement ps = conn.prepareStatement("INSERT userinfo(userName,passWord) VALUES (?,?)");

            ps.setString(1, userName);
            ps.setInt(2, Integer.parseInt(passWord));
            ps.executeUpdate();
            registerType = 0;
            System.out.print("注册成功");
            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registerType;
    }
}
