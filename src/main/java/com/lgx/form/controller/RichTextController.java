package com.lgx.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RichTextController {

    //跳转到富文本的页面
    @RequestMapping("richText.do")
    public ModelAndView jumpToRichTextJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("form/richText");
        return mov;
    }

    @RequestMapping("summernoteWrite.ajax")
    @ResponseBody
    public String summernoteWrite(String writeMessage, MultipartFile file) {
        System.out.println(writeMessage);
        System.out.println(file.getOriginalFilename());
        return null;
    }

    @RequestMapping("summernoteRead.ajax")
    @ResponseBody
    public String summernoteRead() {
        return "231";
    }

}
