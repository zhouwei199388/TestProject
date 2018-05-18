package test.springMVC.dao;

import org.springframework.stereotype.Repository;
import test.springMVC.bean.model.ResponseHeader;
import test.springMVC.bean.response.BaseResponse;
import test.springMVC.bean.model.ShopInfoBean;

import java.sql.*;

/**
 * Created by zouwei on 2018/3/20.
 * <p>
 * 注册
 */
@Repository
public class RegisterDao {

    public BaseResponse register(ShopInfoBean shopInfoBean) {
        BaseResponse response = new BaseResponse();
        ResponseHeader header = new ResponseHeader();
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.shopUrl, ConnectionMessage.user, ConnectionMessage
                    .sqlPassWord);
            PreparedStatement ps;

            ps = conn.prepareStatement("SELECT * FROM shopinfo WHERE shopNumber=?");
            ps.setString(1, shopInfoBean.shopNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                header.resultCode = ConnectionMessage.SUCCESS_CODE;
                header.resultText = ConnectionMessage.USER_EXISTS;
            } else {
                ps = conn.prepareStatement("INSERT shopinfo(shopNumber,passWord,shopName,shopAddress) " +
                        "VALUES " +
                        "(?,?,?,?)");
                ps.setString(1, shopInfoBean.shopNumber);
                ps.setString(2, shopInfoBean.passWord);
                ps.setString(3, shopInfoBean.shopName);
                ps.setString(4, shopInfoBean.shopAddress);
                ps.executeUpdate();
                header.resultCode = ConnectionMessage.SUCCESS_CODE;
                header.resultText = ConnectionMessage.REGISTER_SUCCESS_TEXT;
            }

            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.header = header;
        return response;
    }
}
