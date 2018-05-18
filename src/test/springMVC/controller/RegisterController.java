package test.springMVC.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.springMVC.bean.model.ShopInfoBean;
import test.springMVC.bean.request.BaseRequest;
import test.springMVC.bean.response.BaseResponse;
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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody ShopInfoBean shopInfoBean, HttpServletResponse response) {
        BaseResponse baseResponse = mRegister.register(shopInfoBean);
        ResponseUtils.renderJson(response, new Gson().toJson(baseResponse));
    }
}
