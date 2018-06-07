package com.lgx.tree.service;

import java.util.List;
import java.util.Map;

public interface IAuthorityService {
    public List<Map<String, Object>> getAuthorityTree(int userID);

}
