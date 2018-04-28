package test.springMVC.dao;

import org.springframework.stereotype.Repository;
import test.springMVC.bean.response.ShopInfoResponse;

import java.sql.*;

/**
 * Created by zouwei on 2018/3/19.
 */
@Repository
public class LoginDao {

    public ShopInfoResponse Login(String userName, String passWord) {
        ShopInfoResponse shopInfoResponse = new ShopInfoResponse();
        shopInfoResponse.error();
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.shopUrl, ConnectionMessage.user, ConnectionMessage
                    .sqlPassWord);
            if (!conn.isClosed()) {
                System.out.print("Succeeded connection to the database ");
            }
            PreparedStatement p = conn.prepareStatement("select * from shopinfo WHERE shopNumber=? and passWord=?");

            p.setString(1, userName);
            p.setString(2, passWord);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String username = rs.getString("shopNumber");
                System.out.print("userName = " + username);
                if (username != null && username != "") {
                    shopInfoResponse.success();
                    shopInfoResponse.setShopName(rs.getString("shopName"));
                    shopInfoResponse.setShopNumber(rs.getString("shopNumber"));
                    shopInfoResponse.setShopAddress(rs.getString("shopAddress"));
                    shopInfoResponse.setPassWord(rs.getString("passWord"));
                }
            }else{
                shopInfoResponse.getHeader().setResultText(ConnectionMessage.ERROR_PWD_NULL);
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shopInfoResponse;
    }
}
