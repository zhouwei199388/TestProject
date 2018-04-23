package test.springMVC.bean.response;

import org.springframework.stereotype.Component;
import test.springMVC.bean.BaseHeaderBean;

/**
 * Created by zouwei on 2018/4/17.
 */
@Component
public class ShopInfoResponse extends BaseHeaderBean {

    private String shopName;
    private String passWord;
    private String shopNumber;
    private String shopAddress;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }
}
