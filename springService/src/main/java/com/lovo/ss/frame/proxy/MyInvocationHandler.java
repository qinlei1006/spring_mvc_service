package com.lovo.ss.frame.proxy;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyInvocationHandler {
//    交给框架的被代理者
    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args){

        Object objinfo= null;

        try {
            objinfo = method.invoke(obj,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return objinfo;
    }
}
