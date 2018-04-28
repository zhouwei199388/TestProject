package test.springMVC.bean;

import org.springframework.stereotype.Component;
import test.springMVC.dao.ConnectionMessage;

/**
 * Created by zouwei on 2018/4/17.
 */
@Component
public class Header {
    private int resultCode;
    private String resultText;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }


}
