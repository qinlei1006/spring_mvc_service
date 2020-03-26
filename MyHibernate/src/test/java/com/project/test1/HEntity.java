package com.project.test1;

import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

public class HEntity {

    Session session = null;

    @Before
    public void getSession(){
       session = HSession.createSession();
    }

    @Test
    public void savaRole(){
//        瞬间状态
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName("教师");
//        操作数据库
        Transaction transaction = session.getTransaction();
        transaction.begin();

//        持久状态
        session.save(roleEntity);
//        操作持久状态
        roleEntity.setRoleName("学生");
//        持久状态

        transaction.commit();
        session.close();

//       游离状态
    }


    @Test
    public void roleTest(){
        Transaction transaction = session.getTransaction();
        transaction.begin();
//        因为这个id是数据库中的，再获取这个对象内存也就有。所以是持久状态。
        RoleEntity roleEntity = session.get(RoleEntity.class,"4028098170e167190170e1671ac10000");
//        操作持久状态
        roleEntity.setRoleName("大哥");
//        提交事务：提交事务才，如数据库的数据与内存中不一样会执行update语句将缓存中的数据修改到数据库中，若内存中的数据与数据库一样只执行查询语句。
        transaction.commit();
        session.close();
    }

//    急加载
    @Test
    public void get(){
//        查询出来后放在缓存中
        RoleEntity roleEntity = session.get(RoleEntity.class,"402883b970ec3f9a0170ec3f9c1a0000");
        session.close();
//        从缓存中获取数据，所关闭session后还是可以从缓存中获得数据
        System.out.println("session关闭之后"+roleEntity.getRoleName());


    }


//    懒加载
    @Test
    public void load(){
//      懒加载这里不会获取从数据查询出数据，是在使用这个对象的时候才会执行查询并放到缓存中
        RoleEntity roleEntity = session.load(RoleEntity.class,"4028098170e167190170e1671adc0002");
//      在session关闭前获取session数据并放入缓存。
        System.out.println("session关闭前"+roleEntity.getRoleName());
        session.close();
        System.out.println("session关闭后"+roleEntity.getRoleName());
    }
}
