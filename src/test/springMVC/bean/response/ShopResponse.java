package test.springMVC.bean.response;

import org.springframework.stereotype.Component;
import test.springMVC.bean.BaseHeaderBean;
import test.springMVC.bean.ShopInfoBean;

import java.util.List;

/**
 * Created by zouwei on 2018/4/11.
 */
@Component
public class ShopResponse extends BaseHeaderBean {
    List<ShopInfoBean> shopInfoBeans;

    public List<ShopInfoBean> getShopInfoBeans() {
        return shopInfoBeans;
    }

    public void setShopInfoBeans(List<ShopInfoBean> shopInfoBeans) {
        this.shopInfoBeans = shopInfoBeans;
    }
}
