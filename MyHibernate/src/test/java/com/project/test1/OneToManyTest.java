package com.project.test1;

import com.lovo.hibernate.bean.RUBean;
import com.lovo.hibernate.bean.RoleBean;
import com.lovo.hibernate.bean.UserBean;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OneToManyTest {
    Session session = null;
    Transaction transaction =null;


    @Before   //初始化执行
    public void getSession(){
        //       获得session
        session = HSession.createSession();
//        获得事务
        transaction = session.getTransaction();
//        开启事务
        transaction.begin();

    }


//    @Test
    public void addUser(){
    UserBean userBean = new UserBean();
    userBean.setUserName("张三");

        RoleBean roleBean = new RoleBean();
        roleBean.setRoleName("最高权限");

        RUBean ruBean = new RUBean();
        ruBean.setUser(userBean);
        ruBean.setRole(roleBean);

        session.persist(ruBean);
    }

    @After  // 所有方法执行完后执行
    public void  after(){
        //        提交事务
        transaction.commit();
//        关闭session
        session.close();
    }
}
