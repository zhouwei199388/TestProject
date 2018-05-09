package test.springMVC.bean.response;

import org.springframework.stereotype.Component;
import test.springMVC.dao.ConnectionMessage;

/**
 * Created by zouwei on 2018/4/17.
 */
@Component
public class ResponseHeader {
    public int resultCode;
    public String resultText;
}
