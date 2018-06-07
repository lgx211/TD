package com.lgx.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PDFController {

    //跳转到PDF管理的页面
    @RequestMapping("pdf.do")
    public ModelAndView jumpToPDFJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("file/pdf");
        return mov;
    }
}