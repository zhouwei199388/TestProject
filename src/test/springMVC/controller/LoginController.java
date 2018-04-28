package test.springMVC.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.springMVC.bean.ShopInfoBean;
import test.springMVC.bean.response.ShopInfoResponse;
import test.springMVC.dao.LoginDao;
import test.springMVC.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zouwei on 2017/8/30.
 */
@Controller
public class LoginController {


    @Autowired
    private LoginDao mLoginDao;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(HttpServletResponse response, HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        ShopInfoResponse shopInfoResponse = mLoginDao.Login(userName, passWord);
        ResponseUtils.renderJson(response,new Gson().toJson(shopInfoResponse));
    }


}
