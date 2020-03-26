package com.project.test1;

import com.lovo.hibernate.Dto.TeacherDto;
import com.lovo.hibernate.entity.StudentEntity;
import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.util.HSession;
import com.sun.org.apache.xml.internal.security.encryption.Transforms;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jnlp.ClipboardService;
import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Map;

public class SQL {

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

//    查询所有
    @Test
    public void sql1() {
        String sql = "select * from sys_teacher";
        NativeQuery query = session.createNativeQuery(sql);
        query.addEntity(TeacherEntity.class); //把查询出来的数据放入实体类中，被hibernate管理的实体。
        List<TeacherEntity> list = query.list();
        for (TeacherEntity t:list){
            System.out.println(t.getTeacherId()+"/ "+t.getTeacherName()+"/ "+t.getTeacherClass());
        }

    }

//    查询指定字段
    @Test
    public void sql2(){
        String sql = "select t_name,t_class  from sys_teacher";
       List<Object[]> list=  session.createNativeQuery(sql).list();

        for (Object[] obj:list
        ) {
            System.out.println(obj[0]+"/"+obj[1]);
        }
    }


//    查询指字段，用map接收
    @Test
    public void sql3(){
        String sql = "select t_name,t_class  from sys_teacher  where t_class like ?";
       List<Map> list= session.createNativeQuery(sql).setParameter(1,"%班%")
                .unwrap(NativeQueryImpl.class) //拆包
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP) //封装成map
                .list();
        for (Map m:list){
            System.out.println(m.get("t_name")+" / "+m.get("t_class"));
        }
    }

//   使用dto接收
    @Test
    public void sql4(){
        String sql = "select t_name teacherName,t_class teacherClass  from sys_teacher  where t_class like ?";
        List<TeacherDto> list= session.createNativeQuery(sql).setParameter(1,"%班%")
                .unwrap(NativeQueryImpl.class) //拆包
                .setResultTransformer(Transformers.aliasToBean(TeacherDto.class)) //封装成map
                .list();

        for (TeacherDto t : list){
            System.out.println(t.getTeacherName()+" / "+t.getTeacherClass());
        }
    }


//    连表查询
    public void sql5(){
        String sql = "";

    }

//    分页查询
    @Test
    public void sql6(){
        int currentPage = 1;
        int pageCount = 5;
        String sql = "select * from sys_student ";
      List<StudentEntity> list = session.createNativeQuery(sql)
                .addEntity(StudentEntity.class)
                .setFirstResult((currentPage-1)*pageCount)
                .setMaxResults(pageCount)
                .list();
        for (StudentEntity s:list){
            System.out.println(s.getStudentId()+"，"+s.getStudentName());
        }
    }



    @After  // 所有方法执行完后执行
    public void  after(){
        //        提交事务
        transaction.commit();
//        关闭session
        session.close();
    }
}
