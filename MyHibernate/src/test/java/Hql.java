import com.lovo.hibernate.Dto.TeacherDto;
import com.lovo.hibernate.entity.StudentEntity;
import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.entity.many.MStudentEntity;
import com.lovo.hibernate.util.HSession;
import org.apache.ibatis.annotations.Many;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.jnlp.ClipboardService;
import java.util.List;
import java.util.Map;

public class Hql {
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
    public void hql(){
        String hql = "select s from MStudentEntity s";

        Query query =  session.createQuery(hql);
        List<Object> list = query.list();
        for (Object obj:list
             ) {
            System.out.println(((MStudentEntity)obj).getStudentName());
        }
    }


    /**
     * 查询所有
     */
    @Test
    public void hql1(){
        String hql = "from MStudentEntity s ";
       List<MStudentEntity> studentList = session.createQuery(hql).list();
        for (MStudentEntity s:studentList
             ) {
            System.out.println(s.getStudentName()+"/"+s.getStudentId());
        }
    }


    /**
     * 占位符条件查询
     */
    @Test
    public void hql2(){
        String hql = "from MStudentEntity w here studentName = ? ";

        List<MStudentEntity> studentList = session.createQuery(hql)
                .setParameter(0,"张飞").list();
        for (MStudentEntity s:studentList
        ) {
            System.out.println(s.getStudentName());
        }

    }

    /**
     * 带条件指定属性查询
     */
    @Test
    public void hql3(){
        String hql = "select teacherId,teacherName from TeacherEntity where teacherClass = ? ";
       List<Object[]> list = session.createQuery(hql).setParameter(0,"java班").list();

        for (Object[] obj:list
             ) {
            System.out.println(obj[0].toString()+"/"+obj[1].toString());
        }
    }

    /**
     * 把查出来的属性封装进一个临时的类
     */
    @Test
    public void hql4(){
        String hql = "select new com.lovo.hibernate.Dto.TeacherDto(teacherName,teacherClass) " +
                "from TeacherEntity where teacherClass = ? ";
        List<TeacherDto> list = session.createQuery(hql).setParameter(0,"java班").list();
        for (TeacherDto t:list
             ) {
            System.out.println(t.getTeacherName()+"/"+t.getTeacherClass());
        }
    }


    /**
     * 将查出来的数据装进map集合
     */
    @Test
    public void hql5(){
        String hql = "select new map(teacherName,teacherClass) " +
                "from TeacherEntity where teacherClass like ? ";
        List<Map> list = session.createQuery(hql).setParameter(0,"j%").list();
        for (Map map:list
             ) {
            System.out.println(map.get("0")+"/"+map.get("1"));
        }
    }


//    连表查询
    @Test
         public void hql6(){
          String hql = "select new Map(s.studentName,t.teacherClass,t.teacherName) from StudentEntity s " +
                  "left join s.teacher t where t.teacherName like ?";
          List<Map> list = session.createQuery(hql).setParameter(0,"薛%").list();
        for (Map m : list){
            System.out.println(m.get("0")+"/"+m.get("1")+"/"+m.get("2"));
        }
          }


//          分页查询
    @Test
    public void hql7(){
        int currentPage = 3;
        int pageCount = 5;
        String hql = "from StudentEntity  where studentName like ?";
        List<StudentEntity> list = session.createQuery(hql).setParameter(0,"%生%")
                .setFirstResult((currentPage-1)*pageCount) //起始下标
                .setMaxResults(pageCount)  //每页查询条数
                .list();

        for (StudentEntity s: list){
            System.out.println(s.getStudentId()+"\n"+s.getStudentName()+"\n\n");
        }
    }

//    查询对象
    @Test
    public void hql8(){
        String hql = "from StudentEntity where studentName = ?";
        StudentEntity student = (StudentEntity) session.createQuery(hql)
                .setParameter(0,"学生12").uniqueResult();
        System.out.println("ID："+student.getStudentId()+"\n名字："+student.getStudentName());
    }

//    删除
    @Test
    public void hql9(){
        String hql = "delete StudentEntity where studentName =?";
       int i = session.createQuery(hql).setParameter(0,"学生11")
                .executeUpdate(); //执行修改或删除受影响的行数
        System.out.println(i);
    }


//    修改
    @Test
    public void  hql10(){
        String hql = "update TeacherEntity set teacherClass = ? where teacherName = ?";
      int i =  session.createQuery(hql).setParameter(0,"修改班")
              .setParameter(1,"黄老师").executeUpdate();
        System.out.println(i);
    }


    @After  // 所有方法执行完后执行
    public void  after(){
        //        提交事务
        transaction.commit();
//        关闭session
        session.close();
    }
}
