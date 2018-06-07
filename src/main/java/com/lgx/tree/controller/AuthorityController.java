package com.lgx.tree.controller;

import com.lgx.tree.dto.UserBasicDTO;
import com.lgx.tree.service.IAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AuthorityController {

    @Autowired
    private IAuthorityService authorityService;

    //跳转到权限控制管理的页面
    @RequestMapping("authority.do")
    public ModelAndView jumpToUserJsp() {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("tree/authority");
        return mov;
    }

    @RequestMapping("authorityTree.ajax")
    @ResponseBody
    public List<Map<String, Object>> getAuthorityTree(UserBasicDTO userBasicDTO) {
        return this.authorityService.getAuthorityTree(userBasicDTO.getUserID());
    }


}