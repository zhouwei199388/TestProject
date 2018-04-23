package test.springMVC.bean;

import test.springMVC.dao.ConnectionMessage;

/**
 * Created by zouwei on 2018/4/17.
 */
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

    public void error() {
        this.resultCode = ConnectionMessage.SERVER_ERROR_CODE;
        this.resultText = ConnectionMessage.SERVER_ERROR_TEXT;
    }

    public void success() {
        this.resultCode = ConnectionMessage.SUCCESS_CODE;
        this.resultText = ConnectionMessage.SUCCESS_TEXT;
    }

}
