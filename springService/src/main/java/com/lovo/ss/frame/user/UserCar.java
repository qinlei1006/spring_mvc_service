package com.lovo.ss.frame.user;

import com.lovo.ss.frame.IMessage;

/**
 * 用户指令来操作汽车
 */
public class UserCar implements IMessage {
    /**
     * 获得员工信息
     *
     * @return
     */
    @Override
    public String getMessage() {
        return "start";
    }
}
