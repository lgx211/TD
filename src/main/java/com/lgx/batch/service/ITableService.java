package com.lgx.batch.service;

import com.lgx.batch.dto.TableDTO;
import com.lgx.tree.dto.UserBasicDTO;

import java.util.List;
import java.util.Map;

public interface ITableService {

    List<Map<String, Object>> getTableUser(TableDTO tableDTO, UserBasicDTO userBasicDTO);

    Integer getTableUserCount(TableDTO tableDTO, UserBasicDTO userBasicDTO);
}
