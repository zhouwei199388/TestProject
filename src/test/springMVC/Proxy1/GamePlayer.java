package test.springMVC.Proxy1;



import java.util.Date;

/**
 * Created by 15090 on 2018/5/28.
 */
public class GamePlayer implements IGamePlay {
    private String name;
    private IGamePlay proxy;
    public GamePlayer(String name){
        this.name = name;
    }
    @Override
    public void login(String name, String password) {
        if(this.isProxy()){

            System.out.println("登录游戏时间："+ new Date().getTime());
            System.out.println(name+"   登录游戏");
        }else{
            System.out.println("请使用指定的代理访问");
        }
    }

    @Override
    public void killBoss() {
        if(this.isProxy()){
            System.out.println("正在杀怪");
        }else{
            System.out.println("请使用指定的代理访问");
        }
    }

    @Override
    public void upgrade() {
        if(this.isProxy()){
            System.out.println("升级中");
        }else{
            System.out.println("请使用指定的代理访问");
        }

    }

    @Override
    public IGamePlay getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    private boolean isProxy(){
        if(this.proxy==null){
            return false;
        }else{
            return true;
        }
    }

}
