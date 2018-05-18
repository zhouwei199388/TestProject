package test.springMVC.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.springMVC.bean.model.MenuBean;
import test.springMVC.bean.model.ResponseHeader;
import test.springMVC.bean.response.BaseResponse;
import test.springMVC.bean.response.MenuResponse;
import test.springMVC.dao.MenuDao;
import test.springMVC.utils.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zouwei on 2018/5/7.
 */
@Controller
public class MenuController {
    @Autowired
    private MenuDao mMenuDao;

    @RequestMapping(value = "/addMenu", method = RequestMethod.GET)
    public void addMenu(@RequestBody MenuBean menuBean, HttpServletResponse response) {
        ResponseHeader header = mMenuDao.addMunu(menuBean);
        ResponseUtils.renderJson(response, new Gson().toJson(header));
    }

    /**
     * 获取菜单
     *
     * @param request
     * @param response
     */
    public void getMenus(HttpServletRequest request, HttpServletResponse response) {
        int shopId = (int) request.getAttribute("shopId");
        MenuResponse menuResponse = mMenuDao.getMenus(shopId);
        ResponseUtils.renderJson(response, new Gson().toJson(menuResponse));
    }

}
