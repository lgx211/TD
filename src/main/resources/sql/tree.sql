/**
    建表语句
 */

/*1，机构表 —— 建表语句*/
CREATE TABLE institution_info
(
  int_institution_id        INT AUTO_INCREMENT
  COMMENT '机构id'
    PRIMARY KEY,
  var_institution_name      VARCHAR(40) DEFAULT '' NOT NULL
  COMMENT '机构名称',
  int_parent_institution_id INT                    NOT NULL
  COMMENT '上级机构id',
  CONSTRAINT table_name_int_institution_id_uindex
  UNIQUE (int_institution_id)
)
  ENGINE = InnoDB;


/*2，用户机构表 —— 建表语句*/
CREATE TABLE user_institution_info
(
  int_user_institution_id INT AUTO_INCREMENT
  COMMENT '用户机构id'
    PRIMARY KEY,
  int_user_id             INT NOT NULL
  COMMENT '用户id',
  int_indtitution_id      INT NOT NULL
  COMMENT '机构id',
  CONSTRAINT user_institution_info_int_institution_id_uindex
  UNIQUE (int_user_institution_id)
)
  COMMENT '用户机构信息表'
  ENGINE = InnoDB;


/*3，菜单表 —— 建表语句*/
CREATE TABLE menu_info
(
  int_menu_id        INT AUTO_INCREMENT
  COMMENT '菜单id'
    PRIMARY KEY,
  var_menu_Icon      VARCHAR(40)            NOT NULL
  COMMENT '菜单图标',
  var_menu_name      VARCHAR(20)            NOT NULL
  COMMENT '菜单名称',
  var_menu_Icon2     VARCHAR(40) DEFAULT '' NULL
  COMMENT '菜单图标',
  var_menu_url       VARCHAR(30)            NOT NULL
  COMMENT '菜单地址',
  int_parent_menu_id INT                    NOT NULL
  COMMENT '父菜单id',
  CONSTRAINT menu_info_int_menu_id_uindex
  UNIQUE (int_menu_id)
)
  COMMENT '导航菜单信息表'
  ENGINE = InnoDB;


/*4，菜单按钮表 —— 建表语句*/
CREATE TABLE menu_button_info
(
  int_button_id   INT AUTO_INCREMENT
  COMMENT '按钮id'
    PRIMARY KEY,
  var_button_name VARCHAR(10) NOT NULL
  COMMENT '按钮名称',
  int_menu_id     INT         NOT NULL
  COMMENT '菜单id',
  CONSTRAINT button_info_int_button_id_uindex
  UNIQUE (int_button_id)
)
  COMMENT '菜单按钮信息表'
  ENGINE = InnoDB;


/*5，权限表 —— 建表语句*/
CREATE TABLE authority_info
(
  int_authority_id INT AUTO_INCREMENT
  COMMENT '权限id'
    PRIMARY KEY,
  int_user_id      INT NOT NULL
  COMMENT '用户id',
  int_menu_id      INT NOT NULL
  COMMENT '菜单id',
  int_button_id    INT NOT NULL
  COMMENT '按钮id',
  CONSTRAINT authority_info_int_authority_id_uindex
  UNIQUE (int_authority_id)
)
  COMMENT '权限控制信息表'
  ENGINE = InnoDB;
