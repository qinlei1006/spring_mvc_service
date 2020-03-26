package com.project.test2;

import com.lovo.hibernate.entity.bean.GradeEntity;
import com.lovo.hibernate.entity.bean.RoleEntity;
import com.lovo.hibernate.entity.bean.UserEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class URGTest {
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

    @Test
    public void add(){

        UserEntity user = new UserEntity();
        user.setUserName("张飞");
        user.setPassword("123456");

        UserEntity user2 = new UserEntity();
        user2.setUserName("林冲");
        user2.setPassword("abcde");

        RoleEntity role = new RoleEntity();
        role.setRoleName("经理");
        role.setRoleInfo("打杂的");
        role.setUser(user);

        RoleEntity role2 = new RoleEntity();
        role2.setRoleName("老总");
        role2.setRoleInfo("管钱");
        role2.setUser(user2);

        RoleEntity role3 = new RoleEntity();
        role3.setRoleName("秘书");
        role3.setRoleInfo("有事秘书干");
        role3.setUser(user);

        RoleEntity role4 = new RoleEntity();
        role4.setRoleName("员工");
        role4.setRoleInfo("干苦力的");
        role4.setUser(user2);

        GradeEntity grade = new GradeEntity();
         grade.setGradeName("高级");
         grade.setGradeResource("所有资源");
         grade.setRole(role);

        GradeEntity grade2 = new GradeEntity();
        grade2.setGradeName("中级");
        grade2.setGradeResource("大部分资源");
        grade2.setRole(role2);

        GradeEntity grade3 = new GradeEntity();
        grade3.setGradeName("低高级");
        grade3.setGradeResource("小部分资源");
        grade3.setRole(role4);

        GradeEntity grade4 = new GradeEntity();
        grade4.setGradeName("下下级");
        grade4.setGradeResource("没有资源");
        grade4.setRole(role3);

        GradeEntity grade5 = new GradeEntity();
        grade5.setGradeName("负级");
        grade5.setGradeResource("倒贴资源");
        grade5.setRole(role);


        session.save(grade);
        session.save(grade2);
        session.save(grade3);
        session.save(grade4);
        session.save(grade5);

        session.save(role);
        session.save(role2);
        session.save(role3);
        session.save(role4);

        session.save(user);
        session.save(user2);




    }

    @Test
    public void findByUserName(){
        String sql ="SELECT u.*,r.*,g.* FROM t_user u " +
                "LEFT JOIN t_role r ON u.fk_userId = r.pk_userId " +
                "JOIN t_grade g ON r.fk_roleId = g.pk_roleId " +
                "WHERE u.u_name LIKE ? and u.u_state=? and r.r_state =?";
        List<Object[]> list =
        session.createNativeQuery(sql)
                .addEntity("u",UserEntity.class)
                .addEntity("r",RoleEntity.class)
                .addEntity("g",GradeEntity.class)
                .setParameter(1,"%林%")
                .setParameter(2,"valid")
                .setParameter(3,"valid")
                .list();

        for (Object[] obj : list){
            UserEntity user = (UserEntity) obj[0];
            RoleEntity role = (RoleEntity) obj[1];
            GradeEntity grade = (GradeEntity) obj[2];
            System.out.println(user.getUserID()+"，"+user.getUserName()+","+user.getPassword()+", "+user.getUserState()
            +"\n"+role.getRoleId()+", "+role.getRoleName()+", "+role.getRoleInfo()
            +"\n"+grade.getGradeId()+", "+grade.getGradeName()+", "+grade.getGradeResource());

        }
    }



//    更具用户修改用户的某一个角色为无效的
    @Test
    public void updateState(){
        String sql = "update t_role r,t_user u set r.r_state = 'invalid' " +
                "where u.fk_userId = r.pk_userId " +
                "and u.u_name = ? and  r.r_name = ? ";
       int count =  session.createNativeQuery(sql)
        .setParameter(1,"张飞")
        .setParameter(2,"经理")
        .executeUpdate();
        System.out.println(count);
    }


    @After  // 所有方法执行完后执行
    public void  after(){
        //        提交事务
        transaction.commit();
//        关闭session
        session.close();
    }
}
