package test.springMVC.Proxy;

/**
 * Created by 15090 on 2018/5/28.
 */
public class Client {

    public static void main(String[] args){

        IGamePlay iGamePlay = new GamePlayerProxy("张三");
        iGamePlay.login("zhangsan","123456");
        iGamePlay.killBoss();
        iGamePlay.upgrade();
    }
}
