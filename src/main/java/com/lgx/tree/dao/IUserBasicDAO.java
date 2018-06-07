package com.lgx.tree.dao;

import com.lgx.tree.entity.UserBasicEntity;

import java.util.List;

public interface IUserBasicDAO {

    List<UserBasicEntity> queryUserBasicByInstitutionID(int institution_id);


}
