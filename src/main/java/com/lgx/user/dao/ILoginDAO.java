package com.lgx.user.dao;

import com.lgx.user.entity.UserBasicEntity;

public interface ILoginDAO {

    int checkUserLogin(UserBasicEntity userBasicEntity);
}
