package test.springMVC.Proxy1;

import test.springMVC.Proxy.GamePlayer;

/**
 * Created by 15090 on 2018/5/28.
 */
public class GamePlayerProxy implements IGamePlay {

    private IGamePlay gamePlay = null;

    public GamePlayerProxy(IGamePlay iGamePlay) {
        this.gamePlay = iGamePlay;
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

    @Override
    public IGamePlay getProxy() {
        return this;
    }
}
