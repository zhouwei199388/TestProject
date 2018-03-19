package test.springMVC.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import test.springMVC.bean.UserBean;
import test.springMVC.dao.LoginDao;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zouwei on 2017/8/30.
 */
@Controller
@RequestMapping("/mvc")
public class LoginController {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        LoginDao.Login(userName, passWord);
        return "hello";
    }


}
