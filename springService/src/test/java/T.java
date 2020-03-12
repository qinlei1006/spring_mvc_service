import com.lovo.ss.entity.UserEntity;
import com.lovo.ss.service.IUserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class T {

    @Test
    public  void test(){
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("application.xml");
        IUserService service= (IUserService) context.getBean("userService");



//        UserInfoEntity userInfoEntity = service.findById(2);
//        System.out.println(userInfoEntity.getId());

//        service.addUser(new UserEntity("kkkk","333",22));
//
        List<UserEntity> list = service.affair(new UserEntity("kkkk","333",22));
        for (UserEntity user:list
             ) {
            System.out.println(user.getId()+"  "+user.getUserName()+"  "+user.getAge()+"  "+user.getPassword());
        }

//       UserEntity userEntity = service.findById(1);
//        System.out.println(userEntity.getAge()+userEntity.getUserName());

//        service.addUserInfo(new UserInfoEntity("大boss88",23334, Date.valueOf("2020-01-09"),2));

    }
}
