package com.lovo.ss.frame.proxy;

public class UserProxy implements IUser {
//    持有被代理者
    private IUser user;

    public UserProxy(IUser user) {
        this.user = user;
    }

    @Override
    public void say() {
//        增强功能
        System.out.println("增强功能");
//        调用被代理者的方法
        user.say();
    }
}
