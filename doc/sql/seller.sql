drop  database if exists sirui_store_seller;
create database sirui_store_seller;
use sirui_store_seller;
/* 广告相关表 ,暂时没有 */
/************  商户相关表 ****************************/
/* 卖家表,密保邮箱 */

/*
   todo 商户来源  管理员自己添加 ,商户自己注册
   todo 客服管理
   todo 经营范围是一级分类
   todo 添加客服表
*/
drop table  if exists sr_seller_info;
create table  sr_seller_info(
     id int primary key auto_increment comment '卖家id',
     sn varchar(50) unique key  not null comment '商户编号,uuid ,参考商户表',
     user_id int not null unique key comment '用户id,参考用户表',
     logo varchar(255) not null comment '企业logo 或 个人商户logo',
     state tinyint not null default 0 comment '0-创建成功但是未激活,待审核,1-审核通过已激活,-1 申请未通过 ,10-商户冻结',
     state_remark varchar(255) default null comment '冻结原因或申请未通过原因',
     type tinyint not null default 0  comment '0-企业商户 1-个人商户',
     admin_name varchar(50) not null  comment '管理员的姓名,必须是身份证上的姓名',
     admin_identity_num varchar(50) not null comment '管理员的身份证号码,如果是个人商户就是个人的身份证号码',
     admin_mob_phone varchar(20) not null comment '企业管理员或个人商户的手机号码',
     business_range varchar(255) not null comment '经营范围 以逗号隔开',
     admin_identity_front_url varchar(20) not null comment '企业管理员或个人商户的身份证的正面照片',
     admin_identity_back_url varchar(20) not null comment '企业管理员或个人商户的身份证的背面照片',
     add_by tinyint not null comment '商户来源 0-用户添加,1-管理员自己添加',
       -- 附带信息
     del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
     create_user varchar(100) not null comment '创建人的id',
     update_user varchar(100) not null comment '更新人的id',
     create_time datetime not null comment '创建时间',
     update_time datetime not null comment '更新时间'
)comment '卖家/商户信息表' charset utf8;



/* 在卖家是企业商户的时候 ,需要写入企业信息 一对一的关系 */
drop table if exists sr_seller_enterprise_info  ;
create table sr_seller_enterprise_info(
    seller_sn  varchar(50) unique key  not null comment '商户编号,uuid ,参考商户表',
    enterprise_name varchar(100) not null comment '企业名,必须是营业执照上的',
    tax_sn varchar(30) not null comment '15位企业税号',
    business_lic_num varchar(30) not null comment '15位营业执照注册号',
    province  int(11) not null null comment '省',
    city int(11) not null comment '市',
    county int(11) not null comment '县/区',
    address_detail varchar(100) not null  comment '地址详情',
    tel_phone varchar(20) not null comment '企业座机号码',
    bussiness_lic_img_url varchar(255) not null comment '企业营业执照图片地址',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user varchar(100) not null comment '创建人的id',
    update_user varchar(100) not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
) comment '企业信息表' charset utf8;


/* */
create table sr_seller_bank_info(
    seller_sn varchar(50) unique key  not null comment '商户编号,uuid ,参考商户表',
    legal_person_name   varchar(50)  comment '法人姓名,对于企业商户必须要有法人',
    legal_person_identity_num varchar(50)  comment '法人身份证号码,对于企业商户必须要有法人',
    legal_person_identity_front_url varchar(20)  comment '法人身份证的正面照片',
    legal_person_identity_back_url varchar(20)  comment '法人身份证的背面照片',
    bank_account_name varchar(50)  not null comment '账户开户人姓名',
    bank_name varchar(50) not null comment '开户银行',
    bank_account_card_num  varchar(100) not null comment '开户银行卡号',
    bank_account_permit_num varchar(100) comment '开户许可证编码,对于企业商户必须要有',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user varchar(100) not null comment '创建人的id',
    update_user varchar(100) not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '银行信息表' charset utf8;

/*****************************商铺表 ,商家审核通过后 ,点击立即开店 去创建 店面 ,一个商户只能开一个店铺***********************************************/
drop table if exists sr_seller_store;
create table sr_seller_store(
    id int  primary key auto_increment comment '商铺id',
    name varchar(100) not null comment '店铺名',
    logo varchar(255) not null  comment '店铺logo',
    seller_sn varchar(50) unique key  not null comment '商户编号',
    level tinyint not null default 1 comment '店铺等级1~5',
    status tinyint default 0 comment '店铺状态 0-未激活, 1-已激活 10-冻结',
    status_remark varchar(255) default null  comment  '状态说明 ,比如冻结原因',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user varchar(100) not null comment '创建人的id',
    update_user varchar(100) not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
) comment '商铺表' charset utf8;


drop table if exists user;
create table user(
    id int primary key auto_increment ,
    name varchar(50)  not null unique key ,
    age  tinyint unsigned not null
) charset utf8;

drop table if exists user_info;
create table user_info (
    user_id int unique key,
    nike_name varchar(50) not null
)charset utf8;

insert into user(name,age)values ('jim',22);
insert into user(name,age)values ('han',23);
insert into user(name,age)values ('pom',24);
insert into user(name,age)values ('lava',25);


insert into user_info(user_id, nike_name) values (1,'吉姆');
insert into user_info(user_id, nike_name) values (2,'汗可可');
insert into user_info(user_id, nike_name) values (3,'皮特');
insert into user_info(user_id, nike_name) values (4,'拉哇');

select * from user U left join user_info UI on (U.id=UI.user_id);