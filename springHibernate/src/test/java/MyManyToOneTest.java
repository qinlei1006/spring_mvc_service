import com.lovo.hibernate.entity.StudentEntity;
import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

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
        session.save(teacherEntity);

    }

    @Test
    public void addStudent(){
        TeacherEntity teacherEntity = session.get(TeacherEntity.class,"4028098170eba6370170eba63a450000");
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





    @After  // 所有方法执行完后执行
    public void  after(){
        //        提交事务
        transaction.commit();
//        关闭session
        session.close();
    }

}
