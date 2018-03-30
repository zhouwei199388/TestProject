package test.springMVC.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.springMVC.dao.LoginDao;
import test.springMVC.dao.RegisterDao;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, Model model) {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        int type = mRegister.register(userName, passWord);
        if (type == 0) {
            return "login";
        } else {
            return "hello";
        }
    }
}
