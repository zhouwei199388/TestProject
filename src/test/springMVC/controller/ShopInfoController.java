package test.springMVC.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.springMVC.bean.Shop;
import test.springMVC.bean.ShopInfoBean;
import test.springMVC.dao.ShopInfoDao;
import test.springMVC.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15090 on 2018/4/1.
 */
@Controller
public class ShopInfoController {

    @Autowired
    private ShopInfoDao mShopInfoDao;
    @Autowired
    private ShopInfoBean mShopInfoBean;

    @RequestMapping(value = "/addShopInfoWeb", method = RequestMethod.GET)
    public String addShopInfo() {
        return "shopInfo";
    }


    @RequestMapping(value = "/addShopInfo", method = RequestMethod.POST)
    public String addShopInfo(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mShopInfoBean.setShopName(request.getParameter("shopName"));
        mShopInfoBean.setShopAddress(request.getParameter("shopAddress"));
        System.out.print(mShopInfoBean.getShopName() + "   " + mShopInfoBean.getShopAddress());
        int type = mShopInfoDao.addShopInfo(mShopInfoBean);
        if (type == 0) {
            return "success";
        } else {
            return "error";
        }
    }


    public void modifyShopInfo(HttpServletRequest request, HttpServletResponse response) {


    }


    @RequestMapping(value = "/getShopInfo", method = RequestMethod.GET)
    public void getShopInfo(HttpServletRequest request, HttpServletResponse response) {
        ResponseUtils.renderJson(response, new Gson().toJson(getShopInfos()));
    }

    private Shop getShopInfos() {
        List<ShopInfoBean> shopInfoBeans = new ArrayList<>();
        Shop shop = new Shop();
        for (int i = 0; i < 100; i++) {
            ShopInfoBean shopInfoBean = new ShopInfoBean();
            shopInfoBean.setShopId(i);
            shopInfoBean.setShopName("测试" + i);
            shopInfoBean.setShopAddress("测试地址" + i);
            shopInfoBeans.add(shopInfoBean);
        }
        shop.setShopInfoBeans(shopInfoBeans);
        System.out.print(shopInfoBeans.toString());
        return shop;
    }
}
