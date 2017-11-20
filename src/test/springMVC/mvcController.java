package test.springMVC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import test.springMVC.bean.UserBean;

/**
 * Created by zouwei on 2017/8/30.
 */
@Controller
@RequestMapping("/mvc")
public class mvcController {
    @RequestMapping("/hello")
    public String hello() {
        WebApplicationContext context = (WebApplicationContext) new ClassPathXmlApplicationContext("applicationContext");
        UserBean userBean = (UserBean) context.getBean("userBean");
        System.out.print(userBean.toString());
        return "hello";
    }
}
