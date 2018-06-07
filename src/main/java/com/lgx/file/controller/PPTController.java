package com.lgx.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PPTController {

    //跳转到PPT管理的页面
    @RequestMapping("ppt.do")
    public ModelAndView jumpToPPTJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("file/ppt");
        return mov;
    }
}