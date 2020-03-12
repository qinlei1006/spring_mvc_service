package com.lovo.ss.frame;

public class MyFrame implements IMyFrame {
    @Override
    public void controllerCar(IMessage message) {
//        得到指令
        String info = message.getMessage();
        if (info.equals("start")){
            System.out.println("汽车启动");
        }else if(info.equals("stop")){
            System.out.println("汽车停止");
        }
    }
}
