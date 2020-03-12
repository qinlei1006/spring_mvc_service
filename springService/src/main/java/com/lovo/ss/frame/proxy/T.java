package com.lovo.ss.frame.proxy;

public class T {
    public static void main(String[] args) {
        IUser proxy = new UserProxy(new User());
        proxy.say();
    }
}
