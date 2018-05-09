package test.springMVC.bean.response;

import org.springframework.stereotype.Component;
import test.springMVC.dao.ConnectionMessage;

/**
 * Created by zouwei on 2018/4/17.
 */
@Component
public class BaseResponse {

    public ResponseHeader header;

    public void error() {
        ResponseHeader header = new ResponseHeader();
        header.resultCode = ConnectionMessage.SERVER_ERROR_CODE;
        header.resultText = ConnectionMessage.SERVER_ERROR_TEXT;
        this.header=header;
    }

    public void success() {
        ResponseHeader header = new ResponseHeader();
        header.resultCode = ConnectionMessage.SUCCESS_CODE;
        header.resultText = ConnectionMessage.SUCCESS_TEXT;
        this.header=header;
    }

}
