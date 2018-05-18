package test.springMVC.bean.response;

import test.springMVC.bean.model.MenuBean;
import test.springMVC.dao.MenuDao;

import java.util.List;

/**
 * Created by zouwei on 2018/5/10.
 */
public class MenuResponse extends BaseResponse {

    public List<MenuBean> menuBeans;
}
