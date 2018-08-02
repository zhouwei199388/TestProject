package test.springMVC.Proxy1;


/**
 * Created by 15090 on 2018/5/28.
 */
public class Client {

    public static void main(String[] args){

        GamePlayer player = new GamePlayer("张三");
        IGamePlay playerProxy = player.getProxy();
        playerProxy.login("zhangsan","123");
        playerProxy.killBoss();
        playerProxy.upgrade();
    }
}
