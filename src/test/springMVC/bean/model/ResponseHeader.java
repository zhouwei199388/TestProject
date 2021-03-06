package test.springMVC.bean.model;


import test.springMVC.dao.ConnectionMessage;

/**
 * Created by zouwei on 2018/4/17.
 */
public class ResponseHeader {
    public int resultCode;
    public String resultText;

    public ResponseHeader() {
        setServerError();
    }

    /**
     * 服务器错误
     */
    public void setServerError() {
        this.resultCode = ConnectionMessage.SERVER_ERROR_CODE;
        this.resultText = ConnectionMessage.SERVER_ERROR_TEXT;
    }

    /**
     * 简单请求成功
     */
    public void setSuccess() {
        this.resultCode = ConnectionMessage.SUCCESS_CODE;
        this.resultText = ConnectionMessage.SUCCESS_TEXT;
    }
    /**
     * 简单请求成功
     */
    public void setSuccessNoDate() {
        this.resultCode = ConnectionMessage.SUCCESS_CODE;
        this.resultText = ConnectionMessage.SUCCESS_TEXT;
    }


}
