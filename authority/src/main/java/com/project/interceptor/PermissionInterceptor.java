package com.project.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PermissionInterceptor {


    @RequestMapping("/power1")
    public ModelAndView power1(){
        ModelAndView mv = new ModelAndView("/show.jsp");
        mv.addObject("powerInfo","权限1");
        return mv;
    }

    @RequestMapping("/power2")
    public ModelAndView power2(){
        ModelAndView mv = new ModelAndView("/show.jsp");
        mv.addObject("powerInfo","权限2");
        return mv;
    }

    @RequestMapping("/power3")
    public ModelAndView power3(){
        ModelAndView mv = new ModelAndView("/show.jsp");
        mv.addObject("powerInfo","权限3");
        return mv;
    }

    @RequestMapping("/power4")
    public ModelAndView power4(){
        ModelAndView mv = new ModelAndView("/show.jsp");
        mv.addObject("powerInfo","权限4");
        return mv;
    }

}
