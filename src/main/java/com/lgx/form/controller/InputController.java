package com.lgx.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InputController {

    //跳转到输入框的页面
    @RequestMapping("input.do")
    public ModelAndView jumpToInputJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("form/input");
        return mov;
    }

}
