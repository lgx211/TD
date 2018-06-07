package com.lgx.tree.controller;

import com.lgx.tree.service.IUserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class UserBasicController {

    @Autowired
    private IUserBasicService userBasicService;

    //跳转到组织机构管理的页面
    @RequestMapping("user.do")
    public ModelAndView jumpToUserJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("tree/user");
        return mov;
    }

    //初始化机构树信息
    @RequestMapping("userTree.ajax")
    @ResponseBody
    public List<Map<String, Object>> getUserTree() {
        return this.userBasicService.getUserTree();
    }
}
