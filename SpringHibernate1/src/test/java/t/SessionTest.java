package t;

import com.lovo.sh.dao.BasicDao;
import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SessionTest {

    ClassPathXmlApplicationContext context = null;
    IUserService userService = null;


    @Before
    public void getContext(){

        context = new ClassPathXmlApplicationContext("application.xml");
     userService = (IUserService) context.getBean("userService");
    }


    @Test
    public void test(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        BasicDao basicDao = (BasicDao) context.getBean("basicDao");

        basicDao.test();

    }


    @Test
    public void addUser(){
       for (int i=0;i<10;i++) {
           UserEntity userEntity = new UserEntity(
                   "张三"+i, "1234", "2019-09-09", "xxxxxx", 19);
           userService.saveUser(userEntity);
       }
    }

    @Test
    public void delete(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("4028098171075b480171075b4dd30000");
        userEntity.setUserName("张1");
        userService.delete(userEntity);
    }

    @Test
    public void deleteId(){
        userService.deleteId("4028098171075c5b0171075c60320000");
    }

    @Test
    public void findAll(){
        List<UserEntity> list = userService.findAll();
        for (UserEntity u:list){
            System.out.println(u.getUserName());
        }
    }

    @Test
    public void upbeat(){
        UserEntity userEntity = userService.find("张三");
        userEntity.setPassword("AAAAAAAA");
        userEntity.setInfo("嘻嘻嘻");
        userService.upbeat(userEntity);
    }

    @Test
    public void find(){
        UserEntity userEntity = userService.find("张三9");
        System.out.println(userEntity.getUserId()+"/"+userEntity.getAge());
    }

    @Test
    public void findAge(){
        List<UserEntity> list = userService.findByAge(new Object[]{19,"%7%"});
        for (UserEntity u:list){
            System.out.println(u.getUserId()+"/"+u.getUserName());
        }
    }
}
