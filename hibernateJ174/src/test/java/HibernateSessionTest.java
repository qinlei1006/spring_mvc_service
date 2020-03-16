import com.lovo.hibernate.entity.UserEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateSessionTest {

    @Test
    public void sessionTest(){
        System.out.println(HSession.createSession());
    }

    @Test
    public void addTest(){

        UserEntity userEntity = new UserEntity(1,"张飞","32111",22);
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
     UserEntity userEntity = session.get(UserEntity.class,2);
        System.out.println(userEntity);
        session.close();
    }

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
        userEntity.setUserId(2);
//       执行删除
        session.delete(userEntity);
//        提交事务
        transaction.commit();
//        关闭session
        session.close();
    }

}
