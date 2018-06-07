package com.lgx.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImageController {

    //跳转到Image管理的页面
    @RequestMapping("image.do")
    public ModelAndView jumpToImageJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("file/image");
        return mov;
    }
}