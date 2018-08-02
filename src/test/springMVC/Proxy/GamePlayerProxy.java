package test.springMVC.Proxy;

/**
 * Created by 15090 on 2018/5/28.
 */
public class GamePlayerProxy implements IGamePlay {

    private IGamePlay gamePlay = null;

    public GamePlayerProxy(String name) {
        try {
            gamePlay = new GamePlayer(this, name);
        } catch (Exception e) {
            System.out.print(e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void login(String name, String password) {
        gamePlay.login(name, password);
    }

    @Override
    public void killBoss() {
        gamePlay.killBoss();
    }

    @Override
    public void upgrade() {
        gamePlay.upgrade();
    }
}
