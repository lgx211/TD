package com.lgx.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VideoController {

    //跳转到VIDEO管理的页面
    @RequestMapping("video.do")
    public ModelAndView jumpToVideoJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("file/video");
        return mov;
    }
}