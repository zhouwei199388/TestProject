package test.springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.springMVC.dao.LoginDao;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        int type = mLoginDao.Login(userName, passWord);
        if (type == 0) {
            return "hello";
        } else {
            return "error";
        }
    }


}
