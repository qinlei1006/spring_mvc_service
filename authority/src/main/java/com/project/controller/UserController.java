package com.project.controller;

import com.project.dto.UserGradeDto;
import com.project.entity.UserEntity;
import com.project.service.IGradeService;
import com.project.service.IUserService;
import com.project.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService = null;
    @Autowired
    IGradeService gradeService = null;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody UserVo userVo, HttpServletRequest request){
        System.out.println("�û���"+userVo.getUserName()+"/����"+userVo.getPassword());
        UserEntity userEntity  = userService.login(userVo.getUserName(),userVo.getPassword());
        if (userEntity == null){
            return "noUser";
        }
//        �ѵ�¼�ɹ����û���Ϣװ��session�ֿ�
        request.getSession().setAttribute("loginUser",userEntity);
        List<UserGradeDto> list = gradeService.findByGrade(userEntity.getUserId());

//        ���û��ȼ�װ��session �ֿ�
        request.getSession().setAttribute("userGrade",list);

        return "ok";
    }

    @RequestMapping("/findByGrade")
    @ResponseBody
    public List<UserGradeDto> findByGrade(HttpServletRequest request){
        System.out.println("��ȡ�û��ȼ�");
//        ��session��ȡ���û��ȼ�
        List<UserGradeDto> list =
                (List<UserGradeDto>) request.getSession().getAttribute("userGrade");
        return list;
    }


    @RequestMapping("/test")
    @ResponseBody
    public String t(UserVo userVo){
        System.out.println(userVo.getUserName()+"/"+userVo.getPassword());
        return "ok";
    }

}
