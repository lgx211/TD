package com.lgx.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordController {

    //跳转到WORD管理的页面
    @RequestMapping("word.do")
    public ModelAndView jumpToWordJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("file/word");
        return mov;
    }
}