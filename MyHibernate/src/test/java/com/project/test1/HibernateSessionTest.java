package com.project.test1;

import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.entity.UserEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HibernateSessionTest {

    @Test
    public void sessionTest(){
        System.out.println(HSession.createSession());
    }

    @Test
    public void addTest(){

//       获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String strDate = sdf.format(new Date());

        UserEntity userEntity = new UserEntity("李云飞","0000ff",strDate,"文本数据",18);
//       获得session
        Session session = HSession.createSession();
//        获得事务
        Transaction transaction = session.getTransaction();
//        开启事务
        transaction.begin();
//        执行保存
        session.save(userEntity);
//        提交事务
        transaction.commit();
//        关闭session
        session.close();

    }

    @Test
    public void  selectTest(){
//        得到session
      Session session = HSession.createSession();
//      按照id查询user
     UserEntity userEntity = session.get(UserEntity.class,1);
        System.out.println(userEntity);
        session.close();
    }

    @Test
    public void upbeatTest(){
        //       获得session
        Session session = HSession.createSession();
//        获得事务
        Transaction transaction = session.getTransaction();
//        开启事务
        transaction.begin();
//        查询
        UserEntity userEntity = session.get(UserEntity.class,1);
        userEntity.setAge(33);
        userEntity.setPassword("aaaaaa");
//        执行修改
        session.update(userEntity);
//        事务提交
        transaction.commit();
//        关闭session
        session.close();
    }

    @Test
    public void deleteTest(){
        //       获得session
        Session session = HSession.createSession();
//        获得事务
        Transaction transaction = session.getTransaction();
//        开启事务
        transaction.begin();

//        创建要删除的对象
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("2");
//       执行删除
        session.delete(userEntity);
//        提交事务
        transaction.commit();
//        关闭session
        session.close();
    }

    @Test
    public void roleAddTest(){
        //       获得session
        Session session = HSession.createSession();
//        获得事务
        Transaction transaction = session.getTransaction();
        for (int i=0;i<3;i++) {
//        开启事务
        transaction.begin();
        RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRoleName("管理者00"+i);
//        执行保存
        session.save(roleEntity);
            //        事务提交
            transaction.commit();
        }

//        关闭session
        session.close();
    }

}
