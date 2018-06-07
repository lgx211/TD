package com.lgx.batch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlowController {

    //跳转到瀑布流的页面
    @RequestMapping("flow.do")
    public ModelAndView jumpToFlowJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("batch/flow");
        return mov;
    }
}
