package com.project.interceptor;

import com.project.dto.UserGradeDto;
import com.project.entity.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 过滤器
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean bl = false;
//        获取登录用户
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("loginUser");
//       判断用户是否登录,登录成功获取用户的权限
        if (null != userEntity){
            List<UserGradeDto> list = (List<UserGradeDto>) request.getSession().getAttribute("userGrade");
//            获取用户访问权限
            String path = request.getServletPath();
            if (null != path && path.length()>0){
//                截取访问权的/
                path = path.substring(1,path.length());
            }
//            循环比较用户是否拥有访问的权限
            for (UserGradeDto ug:list){
                if (path.equals(ug.getGradeUrl())){
//                    找到权限放行
                    bl=true;
//                    结束循环
                    break;
                }
            }
        }else {
//            未登录，返回到登录页面
            response.sendRedirect("login.html");
        }
        if (!bl){
//            没有权限返回到登录页面
            response.sendRedirect("login.html");
        }
        return bl;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
