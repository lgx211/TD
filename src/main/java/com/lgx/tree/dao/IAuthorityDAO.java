package com.lgx.tree.dao;

import com.lgx.tree.entity.AuthorityEntity;
import com.lgx.tree.entity.MenuButtonEntity;
import com.lgx.tree.entity.MenuEntity;

import java.util.List;

public interface IAuthorityDAO {

    List<MenuEntity> queryMenu();

    List<MenuButtonEntity> queryButtonByMenuID(int menu_id);

    int queryAuthorityTreeIsChecked(AuthorityEntity authorityEntity);
}
