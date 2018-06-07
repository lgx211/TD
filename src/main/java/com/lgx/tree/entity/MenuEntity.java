package com.lgx.tree.entity;

public class MenuEntity {
    private int menu_id;         //菜单id
    private String menu_Icon;    //菜单图标
    private String menu_name;    //菜单名称
    private String menu_Icon2;   //菜单图标2
    private String menu_url;     //菜单地址
    private int parent_menu_id;  //父菜单id


    private String parent_menu_name;    //父菜单名称

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_Icon() {
        return menu_Icon;
    }

    public void setMenu_Icon(String menu_Icon) {
        this.menu_Icon = menu_Icon;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_Icon2() {
        return menu_Icon2;
    }

    public void setMenu_Icon2(String menu_Icon2) {
        this.menu_Icon2 = menu_Icon2;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public int getParent_menu_id() {
        return parent_menu_id;
    }

    public void setParent_menu_id(int parent_menu_id) {
        this.parent_menu_id = parent_menu_id;
    }

    public String getParent_menu_name() {
        return parent_menu_name;
    }

    public void setParent_menu_name(String parent_menu_name) {
        this.parent_menu_name = parent_menu_name;
    }
}
