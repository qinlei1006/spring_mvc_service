import com.lovo.hibernate.entity.StudentEntity;
import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.util.HSession;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyManyToOneTest {
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
    public void addTeacher(){
          TeacherEntity  teacherEntity = new TeacherEntity();
       teacherEntity.setTeacherName("张老师");
       teacherEntity.setTeacherClass("java班");
        session.save(teacherEntity);

    }


    @Test
    public void cascadeDel(){

        session.delete(session.get(StudentEntity.class,
                "4028098170ecadf30170ecadf5b90001"));

    }



    @Test
    public void addStudent(){
        TeacherEntity teacherEntity = session.get(TeacherEntity.class,"4028098170ecaf340170ecaf36710000");
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName("鲁班");
        studentEntity.setTeacherEntity(teacherEntity);

        StudentEntity studentEntity1 = new StudentEntity();
        studentEntity1.setTeacherEntity(teacherEntity);
        studentEntity1.setStudentName("妲己");

        StudentEntity studentEntity2 = new StudentEntity();
        studentEntity2.setStudentName("王昭君");
        studentEntity2.setTeacherEntity(teacherEntity);

        session.save(studentEntity);
        session.save(studentEntity1);
        session.save(studentEntity2);

    }


      @Test
      public void findOneToMany(){
        TeacherEntity teacherEntity = session.get(TeacherEntity.class,"4028098170ed40170170ed4019b60000");
          System.out.println(teacherEntity);
        for (StudentEntity s:teacherEntity.getStudentSet()
               ) {
              System.out.println(s);
          }
      }


      @Test
      public void addOneToMany(){
        TeacherEntity teacher = new TeacherEntity();
        teacher.setTeacherName("陈老师");
        teacher.setTeacherClass("javaEE班");

        Set<StudentEntity> set= new HashSet<>();
        for (int i =11;i<50;i++){
            StudentEntity student = new StudentEntity("学生"+i);
            student.setTeacherEntity(teacher);
            set.add(student);
        }

        teacher.setStudentSet(set);

        session.persist(teacher);

      }


    @After  // 所有方法执行完后执行
    public void  after(){
        //        提交事务
        transaction.commit();
//        关闭session
        session.close();
    }

}
