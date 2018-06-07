package com.lgx.user.service;

import com.lgx.user.dao.ILoginDAO;
import com.lgx.user.entity.UserBasicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private ILoginDAO userDAO;

    //验证登录
    public int checkUserLogin(UserBasicEntity userBasicEntity) {
        return this.userDAO.checkUserLogin(userBasicEntity);
    }


}
