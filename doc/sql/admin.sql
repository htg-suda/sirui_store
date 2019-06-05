drop  database if exists sirui_store_admin;
create database sirui_store_admin;
use sirui_store_admin;

/* 平台管理员表 */
create table sr_admin(
   id int primary key auto_increment comment '管理员ID ,主键',
   group_id int not null comment '管理员组id , group_id 为 0 是超级管理员 ',
   admin_name varchar(20) unique key not null comment '管理员名',
   admin_password varchar(80) not null comment '管理员密码',
   tel varchar(20) unique key  comment '用户手机号码',
   email varchar(50) unique key  comment '用户电子邮箱',
   status smallint not null default 1001 comment '管理员状态 1001-可用, 1002-不可用',
    -- 附带信息
   del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
   create_user int not null comment '创建人的id',
   update_user int not null comment '更新人的id',
   create_time datetime not null comment '创建时间',
   update_time datetime not null comment '更新时间'
)comment '管理员表' charset utf8;


/* 管理员操作日志表 */
create table sr_admin_opt_log(
   id int primary key auto_increment comment '日志id, 主键',
   admin_id int not null comment '管理员id ,参考管理员 表',
   admin_name varchar(20) unique key not null comment '管理员名',
   log_content varchar(255) not null comment '日志内容',
   -- 附带信息
   del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
   create_user varchar(100) not null comment '创建人的id',
   update_user varchar(100) not null comment '更新人的id',
   create_time datetime not null comment '创建时间',
   update_time datetime not null comment '更新时间'
)comment '管理员操作日志表' charset utf8;

/* 商户  */
