package com.lgx.user.controller;

import com.lgx.user.dto.LoginDTO;
import com.lgx.user.entity.UserBasicEntity;
import com.lgx.user.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private ILoginService loginService;

    @RequestMapping("main.do")
    //登录，跳过了验证
    public ModelAndView jumpToMainJsp(LoginDTO loginDTO) {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("main");
        UserBasicEntity userBasicEntity = new UserBasicEntity();
        userBasicEntity.setUserName(loginDTO.getUserName());
        userBasicEntity.setUserPassword(loginDTO.getUserPassword());

        /*int count = this.loginService.checkUserLogin(userBasicEntity);

        //如果登录失败
        if (count == 0) {
            mov.setViewName("login");
        }
        //如果登录成功
        else if (count == 1) {
            mov.setViewName("main");
        }
        //如果数据异常
        else {
            mov.setViewName("login");
        }*/
        return mov;
    }

    @RequestMapping("login.do")
    public ModelAndView jumpToLoginJsp() {
        System.out.println(111);
        ModelAndView mov = new ModelAndView();
        mov.setViewName("login");
        return mov;
    }

}
