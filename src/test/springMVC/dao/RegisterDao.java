package test.springMVC.dao;

import org.springframework.stereotype.Repository;
import test.springMVC.bean.Header;
import test.springMVC.bean.ShopInfoBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zouwei on 2018/3/20.
 *
 * 注册
 */
@Repository
public class RegisterDao {

    public Header register(ShopInfoBean shopInfoBean) {
        Header header = new Header();
        header.setResultCode(ConnectionMessage.SERVER_ERROR_CODE);
        header.setResultText(ConnectionMessage.SERVER_ERROR_TEXT);
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.shopUrl, ConnectionMessage.user, ConnectionMessage
                    .sqlPassWord);
            if (!conn.isClosed()) {
                System.out.print("Succeeded connection to the database ");
            }
            PreparedStatement ps = conn.prepareStatement("INSERT shopinfo(shopNumber,passWord,shopName,shopAddress) " +
                    "VALUES " +
                    "(?,?,?,?)");
            ps.setString(1, shopInfoBean.getShopNumber());
            ps.setString(2, shopInfoBean.getPassWord());
            ps.setString(3, shopInfoBean.getShopName());
            ps.setString(4, shopInfoBean.getShopAddress());
            ps.executeUpdate();
            header.setResultCode(ConnectionMessage.SUCCESS_CODE);
            header.setResultText(ConnectionMessage.REGISTER_SUCCESS_TEXT);
            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return header;
    }
}
