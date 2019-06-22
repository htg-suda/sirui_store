drop  database if exists sirui_store_user;
create database sirui_store_user;
use sirui_store_user;

-- todo 用户注册 的时候是自己填写用户名还是填写昵称 ?
create table sr_user(
    id int primary key auto_increment comment '用户ID ，主键',
    username varchar(20) unique key not null comment '用户名',
    password varchar(80) not null comment '用户密码',
    nikename varchar(20) default null comment '用户昵称',
    tel varchar(20) unique key  comment '用户手机号码',
    email varchar(50) unique key  comment '用户电子邮箱',
    age tinyint unsigned comment '用户年龄',
    gender tinyint unsigned default 0 comment '性别 1-男 2-女 0-保密',
    status smallint not null default 1001 comment '用户状态 1001-可用, 1002-不可用',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态',
    create_user varchar(100) not null comment '创建人的id',
    update_user varchar(100) not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '用户表' charset utf8;


/* 和用户表是一对一的关系 */
create table sr_user_detail(
    user_id int unique key comment '用户详细信息id 参考用户表',
    invitation_code varchar(50) unique key not null comment '邀请码,随机生成的uuid',
    be_invited tinyint  default 0 comment '是否是被邀请注册 0-不是, 1-是的',
    inviter_id int comment '邀请人的id',
    integral_used int default 0 comment '已使用积分',
    integral_remain int default 0 comment '剩余积分',
    level tinyint default 1 comment '用户等级 1~5',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态',
    create_user varchar(100) not null comment '创建人的id',
    update_user varchar(100) not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '用户详情表' charset utf8;


/* 用户 和角色 组 表 */
/* 最基本的 用户组 */
create table tb_user_role_group(
   id int primary key auto_increment comment '用户角色组id ,主键自增长',
   user_id int not null comment '用户id',
   role_group_id int not null comment '用户组所在的id',
    -- 附带信息
   del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
   create_user varchar(100) not null comment '创建人的id',
   update_user varchar(100) not null comment '更新人的id',
   create_time datetime not null comment '创建时间',
   update_time datetime not null comment '更新时间'
)comment '用户角色组' charset utf8;




create table sr_consignee_address(
    id int primary key auto_increment comment '用户地址id ,主键',
    user_id int not null comment '用户Id ,参考用户表',
    consignee varchar(20) not null  comment '收件人姓名',
    province  int(11) not null null comment '省',
    city int(11) not null comment '市',
    county int(11) not null comment '县/区',
    street int(11) not null comment '街道/乡镇',
    address_detail varchar(100) not null  comment '地址详情',
    tel_phone varchar(20) not null comment '收件人手机号码',
    is_default tinyint default 0 comment '是否是默认收获地址,0-不是, 1-是',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '收件人地址表' charset utf8;


/* 普通用户头像表,一个用户可能有多个头像 */
create table sr_user_portrait (
      id int primary key auto_increment comment '用户头像id 主键',
      user_id int not null comment '用户Id 参考用户表',
      url varchar(255) comment '用户头像url',
      is_default tinyint default 0 comment '是否是当前被使用的那个,0-不是, 1-是',
       -- 附带信息
      del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
      create_user int not null comment '创建人的id',
      update_user int not null comment '更新人的id',
      create_time datetime not null comment '创建时间',
      update_time datetime not null comment '更新时间'
) comment '用户头像表' charset utf8;

create table sr_user_integral(
    id int primary key auto_increment comment '用户积分id',
    user_id int not null comment '用户id',
    integral_info varchar(1000) not null comment '积分详情 json 数组 [{}]',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
) comment '用户积分表' charset utf8;


create table sr_integral_type_category(
    id int primary key  comment '积分品种类别 id',
    type tinyint default 0 comment '积分大类 0-每天登陆,注册成功,邀请注册,商品评论 这些积分直接访问对应值, 1-消费积分,需要按兑换比例进行兑换',
    type_name varchar(20) not null comment '积分品种名',
    category_name varchar(50) not null comment '积分类型名,或者对应的操作名',
    val int default 0 comment '每次操作获取的积分值',
    exchange_prop int default 0 comment '兑换比例 比如设置为10 ,表示消费10单位货币赠送1积分',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '积分品种和类型表 ';


/* 购物消费类积分只能按比例兑换,其他只能*/
insert into sr_integral_type_category(id, type, type_name, category_name, val, exchange_prop, create_user, update_user, create_time, update_time) values
(1,0,'固定项目积分','每天登陆',2,0,0,0,now(),now()),
(2,0,'固定项目积分','注册成功',10,0,0,0,now(),now()),
(3,0,'固定项目积分','邀请注册',10,0,0,0,now(),now()),
(4,0,'固定项目积分','商品评论',10,0,0,0,now(),now()),
(5,0,'兑换项目积分','消费积分',0,10,0,0,now(),now());


                                                                                                                 ;

