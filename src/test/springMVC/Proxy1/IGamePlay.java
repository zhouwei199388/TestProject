package test.springMVC.Proxy1;

/**
 * Created by 15090 on 2018/5/28.
 */
public interface IGamePlay {

    void login(String name, String password);

    void killBoss();

    void upgrade();

    IGamePlay getProxy();
}
