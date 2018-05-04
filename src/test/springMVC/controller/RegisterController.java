package test.springMVC.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.springMVC.bean.Header;
import test.springMVC.bean.ShopInfoBean;
import test.springMVC.dao.LoginDao;
import test.springMVC.dao.RegisterDao;
import test.springMVC.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zouwei on 2018/3/20.
 */
@Controller
public class RegisterController {
    @Autowired
    private RegisterDao mRegister;

    @RequestMapping(value = "/registerWeb", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register(HttpServletRequest request, HttpServletResponse response) {

        ShopInfoBean shopInfoBean = new ShopInfoBean();
        shopInfoBean.setShopName(request.getParameter("shopName"));
        shopInfoBean.setShopAddress(request.getParameter("shopAddress"));
        shopInfoBean.setShopNumber(request.getParameter("shopNumber"));
        shopInfoBean.setPassWord(request.getParameter("passWord"));
        Header header = mRegister.register(shopInfoBean);
        ResponseUtils.renderJson(response, new Gson().toJson(header));
    }
}
