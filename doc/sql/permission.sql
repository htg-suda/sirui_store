drop database if exists sirui_store_permission;
create database sirui_store_permission;
use sirui_store_permission;

create table role_group
(
    id          int primary key comment '权限组id',
    name        varchar(50) not null comment '权限组名',
    -- 附带信息
    del_flag    tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int         not null comment '创建人的id',
    update_user int         not null comment '更新人的id',
    create_time datetime    not null comment '创建时间',
    update_time datetime    not null comment '更新时间'
) comment '权限组表' charset utf8;

insert into role_group (id, name, create_user, update_user, create_time, update_time)
values (1001, '普通用户', 0, 0, now(), now()),
       (2001, '管理员', 0, 0, now(), now()),
       (3001, '商户', 0, 0, now(), now());


/* 权限分类 */
create table permission_category
(
    id          int primary key comment '权限分类id',
    name        varchar(50) not null comment '权限分类名',
    -- 附带信息
    del_flag    tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int         not null comment '创建人的id',
    update_user int         not null comment '更新人的id',
    create_time datetime    not null comment '创建时间',
    update_time datetime    not null comment '更新时间'
) comment '权限分类表' charset utf8;

insert into permission_category value
    (1001, '会员管理', 0, 0, 0, now(), now()),
    (2001, '商品管理', 0, 0, 0, now(), now()),
    (3001, '商户管理', 0, 0, 0, now(), now()),
    (4001, '交易管理', 0, 0, 0, now(), now());


create table permission
(
    id          int primary key comment '权限id',
    category_id int          not null comment '分类id',
    name        varchar(50)  not null comment '权限名',
    code        varchar(50)  not null comment '权限码,用户后端权鉴,如商品管理就是: sys:good:manage',
    resource    varchar(100) not null comment '权限的url地址',
    -- 附带信息
    del_flag    tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int          not null comment '创建人的id',
    update_user int          not null comment '更新人的id',
    create_time datetime     not null comment '创建时间',
    update_time datetime     not null comment '更新时间'
) comment '权限表' charset utf8;


insert into permission
(id, category_id, name, code, resource, create_user, update_user, create_time, update_time)
values
    -- ---------------------------------------------------------------------------------
    -- ------------------------------ 商户端  -------------------------------------------
    -- ---------------------------------------------------------------------------------
    (1001, 2001, '商户端添加商品spu', 'shop:spu:add', '/shop/spu/add', 0, 0, now(), now()),
    (1002, 2001, '商户端获取商品spu详情', 'shop:spu:detail', '/shop/spu/detail/', 0, 0, now(), now()),
    (1003, 2001, '商户端列出商品spu', 'shop:spu:list', '/shop/spu/list', 0, 0, now(), now()),
    (1004, 2001, '商户端修改商品spu', 'shop:spu:modify', '/shop/spu/modify', 0, 0, now(), now()),


    (1005, 2001, '商户端添加商品sku', 'shop:sku:add', '/shop/sku/add', 0, 0, now(), now()),
    (1006, 2001, '商户端获取sku详情', 'shop:sku:detail', '/shop/sku/detail', 0, 0, now(), now()),
    (1007, 2001, '商户端获取sku列表', 'shop:sku:list', '/shop/sku/list/', 0, 0, now(), now()),


    -- ---------------------------------------------------------------------------------
    -- ------------------------------ 系统端 --------------------------------------------
    -- ---------------------------------------------------------------------------------
    -- 分类管理
    (2001, 2001, '系统端添加分类', 'sys:category:add', '/sys/category/add', 0, 0, now(), now()),
    (2002, 2001, '系统端获取分类下品牌', 'sys:category:list_brand', '/sys/category/list_brand/', 0, 0, now(), now()),
    (2003, 2001, '系统端获取分类下子分类', 'sys:category:list_child_category', '/sys/category/list_child_category/', 0, 0, now(),
     now()),
    (2004, 2001, '系统端修改分类', 'sys:category:modify', '/sys/category/modify', 0, 0, now(), now()),


    -- 品牌管理
    (2005, 2001, '系统端添加品牌', 'sys:brand:add', '/sys/brand/add', 0, 0, now(), now()),
    (2006, 2001, '系统端删除品牌', 'sys:brand:del', '/sys/brand/del/', 0, 0, now(), now()),
    (2007, 2001, '系统端列出品牌', 'sys:brand:list', '/sys/brand/list', 0, 0, now(), now()),
    (2008, 2001, '系统端修改品牌信息 和审核状态', 'sys:brand:modify', '/sys/brand/modify', 0, 0, now(), now()),
    (2009, 2001, '系统端为分类添加品牌,或为品牌添加分类', 'sys:brand_category:add', '/sys/brand_category/add', 0, 0, now(), now()),


    -- 规格组管理
    (2010, 2001, '系统端添加规格组', 'sys:spec_group:add', '/sys/spec_group/add', 0, 0, now(), now()),
    (2011, 2001, '系统端获取规格组列表', 'sys:spec_group:list', '/sys/spec_group/list/', 0, 0, now(), now()),

    -- 规格参数管理
    (2012, 2001, '系统端添加规格参数名', 'sys:spec_item:add', '/sys/spec_item/add', 0, 0, now(), now()),
    (2013, 2001, '系统端删除规格参数名', 'sys:spec_item:del', '/sys/spec_item/del/', 0, 0, now(), now()),
    (2014, 2001, '系统端获取规格参数名列表', 'sys:spec_item:list', '/sys/spec_item/list/', 0, 0, now(), now()),

    -- 商品SPU 管理
    (2015, 2001, '系统端获取商品spu详情', 'sys:spu:detail', '/sys/spu/detail/', 0, 0, now(), now()),
    (2016, 2001, '系统端列出商品spu', 'sys:spu:list', '/sys/spu/list', 0, 0, now(), now()),
    (2017, 2001, '系统端修改商品状态,禁售,解禁', 'sys:spu:modify_state', '/sys/spu/modify_state', 0, 0, now(), now()),
    (2018, 2001, '系统端审核商品', 'sys:spu:verify', '/sys/spu/verify', 0, 0, now(), now()),


    -- ---------------------------------------------------------------------------------
    -- ------------------------------  用户端  ------------------------------------------
    -- ---------------------------------------------------------------------------------
    -- 用户端
    (3001, 2001, '用户端获取商品spu详情', 'user:spu:detail', '/user/spu/detail', 0, 0, now(), now()),
    (3002, 2001, '用户端获取商品列表', 'user:spu:list', '/user/spu/list', 0, 0, now(), now());


/* 权限和分组的关系表 多对多 ,一个权限可以在多个组, 一个 组里面有多个权限 */
create table group_permission_mapping
(
    id            int primary key auto_increment comment '权限分组 id',
    group_id      int      not null comment '权限组Id',
    permission_id int      not null comment '权限 id',
    create_user   int      not null comment '创建人的id',
    update_user   int      not null comment '更新人的id',
    create_time   datetime not null comment '创建时间',
    update_time   datetime not null comment '更新时间'
);

/* 为用户组 */
insert into group_permission_mapping
(group_id, permission_id, create_user, update_user, create_time, update_time)
values (1001, 3001, 0, 0, now(), now()),
       (1001, 3002, 0, 0, now(), now());


/* 管理员 */
insert into group_permission_mapping
(group_id, permission_id, create_user, update_user, create_time, update_time)
values (2001, 2001, 0, 0, now(), now()),
       (2001, 2002, 0, 0, now(), now()),
       (2001, 2003, 0, 0, now(), now()),
       (2001, 2004, 0, 0, now(), now()),
       (2001, 2005, 0, 0, now(), now()),
       (2001, 2006, 0, 0, now(), now()),
       (2001, 2007, 0, 0, now(), now()),
       (2001, 2008, 0, 0, now(), now()),
       (2001, 2009, 0, 0, now(), now()),
       (2001, 2010, 0, 0, now(), now()),
       (2001, 2011, 0, 0, now(), now()),
       (2001, 2012, 0, 0, now(), now()),
       (2001, 2013, 0, 0, now(), now()),
       (2001, 2014, 0, 0, now(), now()),
       (2001, 2015, 0, 0, now(), now()),
       (2001, 2016, 0, 0, now(), now()),
       (2001, 2017, 0, 0, now(), now()),
       (2001, 2018, 0, 0, now(), now());


/* 商户组*/
insert into group_permission_mapping
(group_id, permission_id, create_user, update_user, create_time, update_time)
values (3001, 1001, 0, 0, now(), now()),
       (3001, 1002, 0, 0, now(), now()),
       (3001, 1003, 0, 0, now(), now()),
       (3001, 1004, 0, 0, now(), now()),
       (3001, 1005, 0, 0, now(), now()),
       (3001, 1006, 0, 0, now(), now()),
       (3001, 1007, 0, 0, now(), now());