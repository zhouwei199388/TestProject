package test.springMVC.Proxy;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by 15090 on 2018/5/28.
 */
public class GamePlayer implements IGamePlay {
    private String name;
    public GamePlayer(IGamePlay iGamePlay,String name) throws Exception {
        if(iGamePlay==null){
            throw new Exception("不能创建真实角色！");
        }else{
            this.name = name;
        }
    }
    @Override
    public void login(String name, String password) {
        System.out.println("登录游戏时间："+ new Date().getTime());
        System.out.println(name+"   登录游戏");
    }

    @Override
    public void killBoss() {
           System.out.println("正在杀怪");
    }

    @Override
    public void upgrade() {
        System.out.println("升级中");

    }
}
