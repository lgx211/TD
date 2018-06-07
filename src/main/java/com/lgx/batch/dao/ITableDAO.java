package com.lgx.batch.dao;


import com.lgx.tree.entity.UserBasicEntity;

import java.util.List;
import java.util.Map;

public interface ITableDAO {

    List<UserBasicEntity> queryUserBasic(Map<String, Object> map);

    Integer queryUserBasicCount(Map<String, Object> map);
}
