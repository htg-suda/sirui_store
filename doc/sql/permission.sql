drop  database if exists sirui_store_permission;
create database sirui_store_permission;
use sirui_store_permission;

create table role_group(
    id int primary key auto_increment comment '权限组id',
    name varchar(50) not null comment '权限组名',
    permissions varchar(1000) not null comment '权限json 数组 [{"id":2,}]',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '权限组表' charset utf8;


/* 权限分类 */
create table permission_category(
    id int  primary key comment '权限分类id',
    category_num varchar(10) unique key comment '分类编码,用于前端解析',
    name varchar(50) not null comment '权限分类名',
        -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '权限分类表' charset utf8;

insert into permission_category value (1,'a','会员',0,0,now(),now());
insert into permission_category value (2,'b','商品',0,0,now(),now());
insert into permission_category value (3,'c','商户',0,0,now(),now());
insert into permission_category value (4,'d','交易',0,0,now(),now());



create table permission (
    id int primary key auto_increment comment '权限id',
    category_id int not null comment '分类id',
    name varchar(50) not null comment '权限名',
    permission_num tinyint not null comment '权限编码 1,2,3,4... 用户前端解析',
    permission_code varchar(50) not null comment '权限码,用户后端权鉴,如商品管理就是: sys:good:manage',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '权限表' charset utf8;

