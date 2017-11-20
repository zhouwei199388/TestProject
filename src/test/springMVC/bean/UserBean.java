package test.springMVC.bean;

/**
 * Created by zouwei on 2017/9/12.
 */
public class UserBean {

    private String userName;
    private String passWord;

    public UserBean() {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
