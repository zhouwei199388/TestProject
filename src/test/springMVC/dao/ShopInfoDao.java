package test.springMVC.dao;

import org.springframework.stereotype.Repository;
import test.springMVC.bean.ShopInfoBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 15090 on 2018/4/1.
 */
@Repository
public class ShopInfoDao {

    public int setShopInfo(ShopInfoBean shopInfo) {
        int type = 1;
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.shopUrl,ConnectionMessage.user,ConnectionMessage.sqlPassWord);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT shopinfo(shopName,shopAddress) VALUE (?,?)");
            preparedStatement.setString(1,shopInfo.getShopName());
            preparedStatement.setString(2, shopInfo.getShopAddress());
            preparedStatement.executeUpdate();
            type=0;
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }


}
