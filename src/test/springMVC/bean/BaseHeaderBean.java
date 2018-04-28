package test.springMVC.bean;

import org.springframework.stereotype.Component;
import test.springMVC.dao.ConnectionMessage;

/**
 * Created by zouwei on 2018/4/17.
 */
@Component
public class BaseHeaderBean {

    private Header header;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
    public void error() {
        Header header = new Header();
        header.setResultCode(ConnectionMessage.SERVER_ERROR_CODE);
        header.setResultText(ConnectionMessage.SERVER_ERROR_TEXT);
        setHeader(header);
    }

    public void success() {
        Header header = new Header();
        header.setResultCode(ConnectionMessage.SUCCESS_CODE);
        header.setResultText(ConnectionMessage.SUCCESS_TEXT);
        setHeader(header);
    }

}
