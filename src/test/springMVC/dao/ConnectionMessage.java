package test.springMVC.dao;

/**
 * Created by zouwei on 2018/3/20.
 */
public class  ConnectionMessage {
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://127.0.0.1:3306/testDemo";
    public static final String shopUrl = "jdbc:mysql://127.0.0.1:3306/shop";
    public static final String user = "root";
    public static final String sqlPassWord = "zw199388";


    //返回类型
    public static final int SUCCESS_CODE = 0;//请求成功
    public static final int SERVER_ERROR_CODE = 1;//服务器错误
    public static final int TIME_OUT_CODE = 2;//超时

}
