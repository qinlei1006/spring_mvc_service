
import com.project.dto.UserGradeDto;
import com.project.entity.GradeEntity;
import com.project.entity.RoleEntity;
import com.project.entity.UserEntity;
import com.project.service.IGradeService;
import com.project.service.IRoleService;
import com.project.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Tt {

    IUserService userService = null ;
    ClassPathXmlApplicationContext app = null;
    @Before
    public void test(){
        app= new ClassPathXmlApplicationContext("applicationContext.xml");
     userService = (IUserService) app.getBean("userService");

    }



    @Test
    public void saveUser(){
        List<UserEntity> userEntityList = new ArrayList<>();
        for (int i =0;i<1;i++){
            UserEntity user = new UserEntity();
            user.setPassword("密码"+i);
            user.setUserName("名字"+i);
            userEntityList.add(user);
        }
        userService.saveList(userEntityList);
    }

    @Test
    public void saveGrade(){
        IGradeService gradeService = (IGradeService) app.getBean("gradeService");
        List<GradeEntity> gradeEntities = new ArrayList<>();
        for (int i = 0;i<1;i++){
            GradeEntity gradeEntity = new GradeEntity();
            gradeEntity.setGradeName("等级"+i);
            gradeEntities.add(gradeEntity);
        }
        gradeService.saveList(gradeEntities);

    }

    @Test
    public void saveRole(){
        IRoleService gradeService = (IRoleService) app.getBean("roleService");
        List<RoleEntity> roleEntityList = new ArrayList<>();
        for (int i=0;i<5;i++){
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRoleName("角色"+i);
            roleEntityList.add(roleEntity);
        }
        gradeService.saveList(roleEntityList);
    }


    @Test
    public void userLogin(){
        UserEntity userEntity = userService.login("名字1","密码1");
        System.out.println(userEntity.getUserId());
    }

@Test
   public void findByGrade(){
       UserEntity userEntity = userService.login("名字1","密码1");
       IGradeService gradeService = (IGradeService) app.getBean("gradeService");
       System.out.println("用户id"+userEntity.getUserId());
    List<UserGradeDto> gradeList = gradeService.findByGrade(userEntity.getUserId());
       for (UserGradeDto g:gradeList){
           System.out.println(g.getGradeName()+"/"+g.getUserName()+"/"+g.getGradeUrl());
       }
   }

}
