package test.springMVC.dao;

import org.springframework.stereotype.Repository;
import test.springMVC.bean.model.ResponseHeader;
import test.springMVC.bean.response.MenuResponse;
import test.springMVC.bean.model.MenuBean;

import java.sql.*;

/**
 * Created by zouwei on 2018/5/7.
 */
@Repository
public class MenuDao {

    /**
     * 添加菜单
     *
     * @param menuBean
     * @return
     */
    public ResponseHeader addMunu(MenuBean menuBean) {
        ResponseHeader header = new ResponseHeader();
        header.resultCode = ConnectionMessage.SERVER_ERROR_CODE;
        header.resultText = ConnectionMessage.SERVER_ERROR_TEXT;
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.shopUrl, ConnectionMessage.user, ConnectionMessage
                    .sqlPassWord);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT menu(shopId,menuName,price) " +
                    "VALUES (?,?,?,?)");
            preparedStatement.setInt(1, menuBean.shopId);
            preparedStatement.setString(2, menuBean.menuName);
            preparedStatement.setDouble(3, menuBean.price);
            preparedStatement.executeUpdate();
            header.resultCode = ConnectionMessage.SUCCESS_CODE;
            header.resultText = ConnectionMessage.SUCCESS_TEXT;
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return header;
    }


    /**
     * 根据店id查相关菜单
     * @param shopId
     * @return
     */
    public MenuResponse getMenus(int shopId) {
        MenuResponse menuResponse = new MenuResponse();
        ResponseHeader header = new ResponseHeader();
        Connection conn;
        try {
            Class.forName(ConnectionMessage.driver);
            conn = DriverManager.getConnection(ConnectionMessage.shopUrl, ConnectionMessage.user, ConnectionMessage
                    .sqlPassWord);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM menu WHERE shopId =?");
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                header.setSuccess();
                MenuBean menuBean = new MenuBean();
                menuBean.id = rs.getInt("id");
                menuBean.shopId = rs.getInt("shopId");
                menuBean.menuName = rs.getString("menuName");
                menuBean.price = rs.getDouble("price");
                menuResponse.menuBeans.add(menuBean);
            } else {
                header.setSuccessNoDate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuResponse;
    }
}
