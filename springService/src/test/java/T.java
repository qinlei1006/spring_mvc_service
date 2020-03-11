import com.lovo.ss.entit.UserEntity;
import com.lovo.ss.entit.UserInfoEntity;
import com.lovo.ss.service.IUserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class T {

    @Test
    public  void test(){
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("application.xml");
        IUserService service= (IUserService) context.getBean("userService");


        service.addUser(new UserEntity("ssss","333",22));
//       UserEntity userEntity = service.findById(1);
//        System.out.println(userEntity.getAge()+userEntity.getUserName());

//        service.addUserInfo(new UserInfoEntity("老板88",23334, Date.valueOf("2020-01-09"),2));

    }
}
