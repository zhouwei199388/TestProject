package test.springMVC.dao;

import org.springframework.stereotype.Repository;
import test.springMVC.bean.model.ResponseHeader;
import test.springMVC.bean.model.ShopInfoBean;
import test.springMVC.bean.response.ShopInfoResponse;

import java.sql.*;

/**
 * Created by zouwei on 2018/3/19.
 */
@Repository
public class LoginDao {

    public ShopInfoResponse Login(String userName, String passWord) {
        ShopInfoResponse shopInfoResponse = new ShopInfoResponse();
        ResponseHeader header = new ResponseHeader();
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
                    header.setSuccess();
                    ShopInfoBean shopInfo = new ShopInfoBean();
                    shopInfo.shopId = rs.getInt("shopId");
                    shopInfo.shopName = rs.getString("shopName");
                    shopInfo.shopNumber = rs.getString("shopNumber");
                    shopInfo.shopAddress = rs.getString("shopAddress");
                    shopInfo.passWord = rs.getString("passWord");
                    shopInfoResponse.shopInfo = shopInfo;
                }
            } else {
                shopInfoResponse.header.resultText = ConnectionMessage.ERROR_PWD_NULL;
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        shopInfoResponse.header = header;
        return shopInfoResponse;
    }
}
