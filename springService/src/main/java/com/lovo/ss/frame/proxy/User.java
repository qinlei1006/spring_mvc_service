package com.lovo.ss.frame.proxy;

public class User implements IUser {
    @Override
    public void say() {
        System.out.println("接口实现类");
    }
}
