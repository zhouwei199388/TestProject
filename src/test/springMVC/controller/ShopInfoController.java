package test.springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.springMVC.bean.ShopInfoBean;
import test.springMVC.dao.ShopInfoDao;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 15090 on 2018/4/1.
 */
@Controller
public class ShopInfoController {

    @Autowired
    private ShopInfoDao mShopInfoDao;
    @Autowired
    private ShopInfoBean mShopInfoBean;
    @RequestMapping(value = "/addShopInfoWeb",method = RequestMethod.GET)
    public String addShopInfo(){
        return "shopInfo";
    }


    @RequestMapping(value = "/addShopInfo",method = RequestMethod.POST)
    public String addShopInfo(HttpServletRequest request) {
        mShopInfoBean.setShopName(request.getParameter("shopName"));
        mShopInfoBean.setShopName(request.getParameter("shopAddress"));
        int type = mShopInfoDao.setShopInfo(mShopInfoBean);
        if (type == 0) {
            return "shopInfo";
        } else {
            return "error";
        }
    }
}
