package test.springMVC.bean;

import java.util.List;

/**
 * Created by zouwei on 2018/4/11.
 */
public class Shop {
    List<ShopInfoBean> shopInfoBeans;

    public List<ShopInfoBean> getShopInfoBeans() {
        return shopInfoBeans;
    }

    public void setShopInfoBeans(List<ShopInfoBean> shopInfoBeans) {
        this.shopInfoBeans = shopInfoBeans;
    }
}
