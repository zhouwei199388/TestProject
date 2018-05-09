package test.springMVC.bean.response;

import org.springframework.stereotype.Component;
import test.springMVC.bean.model.ShopInfoBean;

import java.util.List;

/**
 * Created by zouwei on 2018/4/11.
 */
@Component
public class ShopInfos extends BaseResponse {
   public List<ShopInfoBean> shopInfoBeans;

}
