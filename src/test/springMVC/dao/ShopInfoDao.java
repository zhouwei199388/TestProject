package test.springMVC.dao;

import org.springframework.stereotype.Repository;
import test.springMVC.bean.model.ShopInfoBean;

import java.sql.*;

/**
 * Created by 15090 on 2018/4/1.
 */
@Repository
public class ShopInfoDao {

    /**
     * 添加账户及信息
     *
     * @param shopInfo
     * @return
     */
    public int addShopInfo(ShopInfoBean shopInfo) {
        int type = ConnectionMessage.SERVER_ERROR_CODE;
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.shopUrl, ConnectionMessage.user, ConnectionMessage.sqlPassWord);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT shopinfo(shopName,shopAddress) " +
                    "VALUE (?,?)");
            System.out.print(shopInfo.shopAddress);
            preparedStatement.setString(1, shopInfo.shopName);
            preparedStatement.setString(2, shopInfo.shopAddress);
            preparedStatement.executeUpdate();
            type = ConnectionMessage.SUCCESS_CODE;
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    /**
     * 修改商户信息
     *
     * @param shopInfoBean
     * @return
     */
    public int modifyShopInfo(ShopInfoBean shopInfoBean) {
        int type = ConnectionMessage.SERVER_ERROR_CODE;
        String sql = "update shopinfo set";
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.url, ConnectionMessage.user, ConnectionMessage
                    .sqlPassWord);
            PreparedStatement ps = conn.prepareStatement("UPDATE shopinfo SET shopName=? shopAddress=? WHERE shopId " +
                    "LIKE ?");
            ps.setString(1, shopInfoBean.shopName);
            ps.setString(2, shopInfoBean.shopAddress);
            ps.setInt(3, shopInfoBean.shopId);
            ps.executeUpdate();
            type = ConnectionMessage.SUCCESS_CODE;
            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    /**
     * 是否存在数据
     *
     * @param shopId
     * @return
     */
    public boolean sqlExists(int shopId) {
        boolean type = false;
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.url, ConnectionMessage.user, ConnectionMessage
                    .sqlPassWord);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM shopinfo WHERE shopId = ?");
            preparedStatement.setInt(1, shopId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

}
