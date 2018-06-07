/**
    建表语句
 */

/*1，用户基础表 —— 建表语句*/
CREATE TABLE user_basic_info
(
  int_user_id    INT AUTO_INCREMENT
  COMMENT '用户id'
    PRIMARY KEY,
  var_user_name  VARCHAR(10) NOT NULL
  COMMENT '用户姓名',
  var_login_name VARCHAR(20) NOT NULL
  COMMENT '用户登录名',
  var_password   VARCHAR(20) NOT NULL
  COMMENT '登录密码',
  CONSTRAINT user_basic_info_int_user_id_uindex
  UNIQUE (int_user_id),
  CONSTRAINT user_basic_info_var_login_name_uindex
  UNIQUE (var_login_name)
)
  COMMENT '用户基础信息表'
  ENGINE = InnoDB;