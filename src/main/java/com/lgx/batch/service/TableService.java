package com.lgx.batch.service;

import com.lgx.batch.dao.ITableDAO;
import com.lgx.batch.dto.TableDTO;
import com.lgx.tree.dto.UserBasicDTO;
import com.lgx.tree.entity.UserBasicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableService implements ITableService {
    @Autowired
    private ITableDAO tableDao;

    //字段转化
    public static String convertSearchName(String name) {
        Map<String, String> tableMap = new HashMap();
        tableMap.put("userName", "user_name");
        tableMap.put("loginName", "login_name");
        return tableMap.get(name);
    }

    public List<Map<String, Object>> getTableUser(TableDTO tableDTO, UserBasicDTO userBasicDTO) {
        Map<String, Object> map = new HashMap();
        map.put("page_size", tableDTO.getPageSize());
        map.put("page_number", tableDTO.getPageNumber());
        map.put("sort_name", convertSearchName(tableDTO.getSortName()));
        map.put("sort_order", tableDTO.getSortOrder());

        map.put("login_name", userBasicDTO.getLoginName());
        map.put("user_name", userBasicDTO.getUserName());

        List<Map<String, Object>> mapList = new ArrayList();
        List<UserBasicEntity> userBasicEntityList = this.tableDao.queryUserBasic(map);
        for (UserBasicEntity userBasicEntity : userBasicEntityList) {
            Map<String, Object> map2 = new HashMap();
            map2.put("userID", userBasicEntity.getUser_id());
            map2.put("loginName", userBasicEntity.getLogin_name());
            map2.put("userName", userBasicEntity.getUser_name());
            mapList.add(map2);
        }

        return mapList;
    }

    public Integer getTableUserCount(TableDTO tableDTO, UserBasicDTO userBasicDTO) {
        Map<String, Object> map = new HashMap();
        map.put("login_name", userBasicDTO.getLoginName());
        map.put("user_name", userBasicDTO.getUserName());
        return this.tableDao.queryUserBasicCount(map);
    }
}
