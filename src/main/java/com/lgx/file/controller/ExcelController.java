package com.lgx.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExcelController {

    //跳转到EXCEL管理的页面
    @RequestMapping("excel.do")
    public ModelAndView jumpToExcelJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("file/excel");
        return mov;
    }
}