package com.lgx.user.service;

import com.lgx.user.entity.UserBasicEntity;

public interface ILoginService {

    //验证登录
    public int checkUserLogin(UserBasicEntity userBasicEntity);


}
