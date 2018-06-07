package com.lgx.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ComboBoxController {

    //跳转到组合框页面
    @RequestMapping("comboBox.do")
    public ModelAndView jumpToComboBoxJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("form/comboBox");
        return mov;
    }
}
