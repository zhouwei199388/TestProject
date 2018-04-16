package test.springMVC.bean;

import org.springframework.stereotype.Component;

/**
 * Created by 15090 on 2018/4/1.
 */
@Component
public class ShopInfoBean {
    private int shopId;
    private String shopName;
    private String shopAddress;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }
}
