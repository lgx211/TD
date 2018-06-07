package com.lgx.tree.service;

import com.lgx.tree.dao.IInstitutionDAO;
import com.lgx.tree.dao.IUserBasicDAO;
import com.lgx.tree.entity.InstitutionEntity;
import com.lgx.tree.entity.UserBasicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBasicService implements IUserBasicService {

    @Autowired
    private IUserBasicDAO userBasicDAO;
    @Autowired
    private IInstitutionDAO institutionDAO;

    // 用户树
    public List<Map<String, Object>> getUserTree() {
        List<Map<String, Object>> userTree = new ArrayList<Map<String, Object>>();
        // 获取机构信息
        List<InstitutionEntity> institutionEntityList = this.institutionDAO
                .queryInstitution();
        // 将角色封装成树结构
        for (InstitutionEntity institutionEntity : institutionEntityList) {
            Map<String, Object> map = null;
            if (institutionEntity.getParent_institution_id() == 0) {
                map = new HashMap<String, Object>();
                // 将id、name等转换成前台界面的显示形式id、text。第一级菜单默认展开
                map.put("id", institutionEntity.getInstitution_id());
                map.put("name", institutionEntity.getInstitution_name());
                map.put("children", getUserChildTree(institutionEntityList,
                        institutionEntity.getInstitution_id()));
            }
            if (map != null) {
                userTree.add(map);
            }
        }
        return userTree;
    }

    // 子树
    private List<Map<String, Object>> getUserChildTree(List<InstitutionEntity> institutionEntityList, int pID) {

        List<Map<String, Object>> userChildTree = new ArrayList<Map<String, Object>>();

        for (InstitutionEntity institutionEntity : institutionEntityList) {
            Map<String, Object> map = null;
            if (institutionEntity.getParent_institution_id() == pID) {
                map = new HashMap<String, Object>();
                map.put("id", 0 - institutionEntity.getInstitution_id());
                map.put("name", institutionEntity.getInstitution_name());
                map.put("children", getUserChildTree(institutionEntityList,
                        institutionEntity.getInstitution_id()));
                List<Map<String, Object>> children = getUserChildTree(
                        institutionEntityList, institutionEntity.getInstitution_id());
                // 除了一级菜单，最后一级菜单，其余的默认不展开状态。
                // 如果该机构下没有子机构，是最后一级机构。查找该机构下的用户
                if (children != null && !children.isEmpty()) {
                    map.put("open", "false");
                } else {
                    List<Map<String, Object>> userList = this.getUserTreeChildNode(
                            institutionEntity.getInstitution_id());
                    map.put("children", userList);
                }
            }
            if (map != null) {
                userChildTree.add(map);
            }
        }
        return userChildTree;
    }

    // 最后一级机构下的用户。根据机构id查用户信息
    private List<Map<String, Object>> getUserTreeChildNode(int institution_id) {
        List<Map<String, Object>> userTreeChildNode = new ArrayList<Map<String, Object>>();

        List<UserBasicEntity> userBasicEntityList = this.userBasicDAO
                .queryUserBasicByInstitutionID(institution_id);

        for (UserBasicEntity userBasicEntity : userBasicEntityList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", userBasicEntity.getUser_id());
            map.put("name", userBasicEntity.getLogin_name());
            userTreeChildNode.add(map);
        }
        return userTreeChildNode;
    }
}

