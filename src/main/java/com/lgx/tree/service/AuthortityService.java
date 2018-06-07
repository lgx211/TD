package com.lgx.tree.service;

import com.lgx.tree.dao.IAuthorityDAO;
import com.lgx.tree.entity.AuthorityEntity;
import com.lgx.tree.entity.MenuButtonEntity;
import com.lgx.tree.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthortityService implements IAuthorityService {

    @Autowired
    private IAuthorityDAO authorityDAO;

    //权限树
    public List<Map<String, Object>> getAuthorityTree(int user_id) {
        List<Map<String, Object>> authorityTree = new ArrayList<Map<String, Object>>();

        //获取导航目录
        List<MenuEntity> menuEntityList = this.authorityDAO.queryMenu();
        for (MenuEntity menuEntity : menuEntityList) {
            Map<String, Object> map = null;
            if (menuEntity.getParent_menu_id() == 0) {
                map = new HashMap<String, Object>();
                // 将id、name等转换成前台界面的显示形式id、text。第一级菜单默认展开
                map.put("id", menuEntity.getMenu_id());
                map.put("name", menuEntity.getMenu_name());
                map.put("children", getAuthorityChildTree(menuEntityList,
                        menuEntity.getMenu_id(), user_id));
                map.put("open", "true");
            }
            if (map != null) {
                authorityTree.add(map);
            }
        }
        return authorityTree;
    }

    //子菜单目录
    public List<Map<String, Object>> getAuthorityChildTree(List<MenuEntity> menuEntityList, int pID, int user_id) {
        List<Map<String, Object>> authorityChildTree = new ArrayList<Map<String, Object>>();

        for (MenuEntity menuEntity : menuEntityList) {
            Map<String, Object> map = null;
            if (menuEntity.getParent_menu_id() == pID) {
                map = new HashMap<String, Object>();
                map.put("id", 0 - menuEntity.getMenu_id());
                map.put("name", menuEntity.getMenu_name());
                map.put("children", getAuthorityChildTree(menuEntityList,
                        menuEntity.getMenu_id(), user_id));
                //全部展开
                map.put("open", "true");
                // 如果该目录下没有子目录，是最后一级目录。查找该目录下的用户按钮
                List<Map<String, Object>> children = getAuthorityChildTree(
                        menuEntityList, menuEntity.getMenu_id(), user_id);
                if (children != null && !children.isEmpty()) {

                } else {
                    List<Map<String, Object>> userList = this.getAuthorityTreeChildNode(
                            menuEntity.getMenu_id(), user_id);
                    map.put("children", userList);
                }
            }
            if (map != null) {
                authorityChildTree.add(map);
            }
        }
        return authorityChildTree;
    }

    //子菜单目录下对应的按钮
    public List<Map<String, Object>> getAuthorityTreeChildNode(int menu_id, int user_id) {
        List<Map<String, Object>> authorityTreeChildNode = new ArrayList<Map<String, Object>>();

        List<MenuButtonEntity> menuButtonEntityList = this.authorityDAO.queryButtonByMenuID(menu_id);

        for (MenuButtonEntity menuButtonEntity : menuButtonEntityList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", menuButtonEntity.getButton_id());
            map.put("name", menuButtonEntity.getButton_name());

            AuthorityEntity authorityEntity = new AuthorityEntity();
            authorityEntity.setButton_id(menuButtonEntity.getButton_id());
            authorityEntity.setMenu_id(menu_id);
            authorityEntity.setUser_id(user_id);
            int isChecked = this.authorityDAO.queryAuthorityTreeIsChecked(authorityEntity);

            if (isChecked == 1) {
                map.put("checked", "true");
            }

            authorityTreeChildNode.add(map);
        }
        return authorityTreeChildNode;
    }

}
