import com.lovo.hibernate.entity.many.MStudentEntity;
import com.lovo.hibernate.entity.many.MTeacherEntity;
import com.lovo.hibernate.util.HSession;
import net.bytebuddy.jar.asm.commons.Method;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ManyToManyTest {

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
    public void saveMany(){
        MTeacherEntity teacher = new MTeacherEntity();
        teacher.setTeacherName("张老师");

        MTeacherEntity teacherEntity = new MTeacherEntity();
        teacherEntity.setTeacherName("陈老师");

        MStudentEntity s = new MStudentEntity();
        s.setStudentName("薛飞");

        MStudentEntity s2 = new MStudentEntity();
        s2.setStudentName("关羽");

        MStudentEntity s3 = new MStudentEntity();
        s3.setStudentName("妲己");

        Set<MStudentEntity> studentSet = new HashSet<>();
        studentSet.add(s);
        studentSet.add(s2);
        studentSet.add(s3);

        Set<MStudentEntity> studentSet2 = new HashSet<>();
        studentSet2.add(s2);
        studentSet2.add(s3);

        teacher.setStudentSet(studentSet);
        teacherEntity.setStudentSet(studentSet2);
        session.save(s);
        session.save(s2);
        session.save(s3);
        session.save(teacher);
        session.save(teacherEntity);


    }


    @Test
    public void getMany(){
        MTeacherEntity teacher = session.get(MTeacherEntity.class,"4028098170f1010d0170f1010fde0004");
        System.out.println("老师名字："+teacher.getTeacherName());
        Set<MStudentEntity> set = teacher.getStudentSet();
        for (MStudentEntity s: set
             ) {
            System.out.println("学生名字："+s.getStudentName());
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
