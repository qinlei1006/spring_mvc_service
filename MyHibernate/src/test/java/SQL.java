import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @After  // 所有方法执行完后执行
    public void  after(){
        //        提交事务
        transaction.commit();
//        关闭session
        session.close();
    }
}
