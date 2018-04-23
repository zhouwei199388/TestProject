package test.springMVC.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.springMVC.bean.response.ShopInfoResponse;

import java.sql.*;

/**
 * Created by zouwei on 2018/3/19.
 */
@Repository
public class LoginDao {
    @Autowired
    private ShopInfoResponse mShopInfo;

    public ShopInfoResponse Login(String userName, String passWord) {
        mShopInfo.getHeader().error();
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.url, ConnectionMessage.user, ConnectionMessage.sqlPassWord);
            if (!conn.isClosed()) {
                System.out.print("Succeeded connection to the database ");
            }
            PreparedStatement p = conn.prepareStatement("select * from shopinfo WHERE shopNumber=? and passWord=?");

            p.setString(1, userName);
            p.setString(2, passWord);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String username = rs.getString("userName");
                System.out.print("userName = " + username);
                if (username != null && username != "") {
                    mShopInfo.getHeader().success();
                    mShopInfo.setShopName(rs.getString("shopName"));
                    mShopInfo.setShopNumber(rs.getString("shopNumber"));
                    mShopInfo.setShopAddress(rs.getString("shopAddress"));
                    mShopInfo.setPassWord(rs.getString("passWord"));
                }
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mShopInfo;
    }
}
