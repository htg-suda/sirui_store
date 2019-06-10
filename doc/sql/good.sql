drop  database if exists sirui_store_good;
create database sirui_store_good;
use sirui_store_good;
/* 商品分类 表*/
create table sr_good_category(
   id int primary key auto_increment comment '商品分类id',
   parent_id int default 0  comment '父级别的类id, id为0的时候是根分类',
   name varchar(50) not null comment '分类名',
   icon  varchar(255)  comment '分类图标url',
   sort tinyint not null  comment '分类排序字段 0~100,越小越靠前',
   commission_rate decimal(5,2) comment '佣金比例',
    -- 附带信息
   del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
   create_user int not null comment '创建人的id',
   update_user int not null comment '更新人的id',
   create_time datetime not null comment '创建时间',
   update_time datetime not null comment '更新时间'
) comment '商品分类表' charset utf8;



/* 品牌表 */
/* todo 谁可以添加品牌 , 是系统管理员,还是 商家? 品牌冲突了怎么办?? 如何认定一个品牌是已经有? 如 不同的分类下如果有相同的 品牌算不算重复了? */
create table sr_brand(
    id int primary key auto_increment comment '品牌表id',
    name_cn varchar(20) default null comment '品牌中文名',
    name_eg varchar(20) default null comment '品牌英文名',
    icon  varchar(255)  comment '品牌图标url',
    initial varchar(1) not null comment '品牌首字母,必须大写',
    sort tinyint not null  comment '品牌排序字段 0~100,越小越靠前',
    ascription tinyint default 0 comment '品牌归属 0-商家, 1-平台',
    verify tinyint default 0 comment '商品审核 1-通过，0-未通过，10-审核中',
    verify_remark varchar(255) default null comment '审核不通过原因',

    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '品牌表' charset utf8;


/* 品牌和分类的关系表 ,是多对多的关系*/
create table sr_brand_category(
    id int primary key auto_increment comment '品牌表id',
    category_id int not  null  comment '分类表id',
    brand_id int not null  comment '品牌表id',
-- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
   create_user int not null comment '创建人的id',
   update_user int not null comment '更新人的id',
   create_time datetime not null comment '创建时间',
   update_time datetime not null comment '更新时间'
)comment '品牌和分类的关系表' charset utf8;



-- -----------------------------------------------------------------
-- 创建 规格组
create table tb_good_spec_group(
     id int primary key auto_increment comment '规格主键',
     name varchar(20) not null comment '规格组名',
     category_id  int not null comment '商品分类id',
    -- 附带信息
     del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
     create_user int not null comment '创建人的id',
     update_user int not null comment '更新人的id',
     create_time datetime not null comment '创建时间',
     update_time datetime not null comment '更新时间'
)charset utf8 comment '规格组表';


-- 创建规格参数名表
create table tb_good_spec_item(
     id int primary key auto_increment comment '规格参数名主键',
     name varchar(20) not null comment '规格参数健值',
     category_id int not null comment '产品分类id',
     group_id int  not null comment '规格组id ',
     spec_type  varchar(20) not null comment '规格值的类型, num-数值类型 , enum 枚举类型 ,str-文本类型,images-图片url地址如xxx.png;xxx.png',
     enum_options varchar(1000) comment '如果是枚举类型的话,其各个枚举值,以逗号分割',
     unit varchar(20) default null comment '在为数值类型的时候的单位,比如12mm中的mm',
     is_general tinyint default 1 comment '是否属于spu的通用规格属性 0-不是, 1-是',
     is_necessary tinyint default 1 comment '是否必填,0-不是, 1-是' ,
    -- 附带信息
     del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
     create_user int not null comment '创建人的id',
     update_user int not null comment '更新人的id',
     create_time datetime not null comment '创建时间',
     update_time datetime not null comment '更新时间'
)charset utf8 comment '规格参数名表';


/*-- 规格参数表和规格组表的关系,一对多的关系
create table  tb_good_spec_group_item(
    id int primary key comment '主键',
    spec_item_id int not null comment '规格参数名id',
    group_id int not null comment '规格组id ',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
     create_user int not null comment '创建人的id',
     update_user int not null comment '更新人的id',
     create_time datetime not null comment '创建时间',
     update_time datetime not null comment '更新时间'
)charset utf8 comment '规格参数表和规格组表的关系表';
*/



/*
{"list":[{"groupId":1,"groupName":"位置","items":[{"specItemId":2,"specName":"地址","specItemValue":"浦江镇,浦晓南路51弄","is_necessary":1,"is_general":0}]},{}]}

*/


/* 商品spu表 太大,要拆成两张表 一对一关系, 一张用于显示列表 ,一张用于现实详情*/
create table sr_good_spu(
    id int primary key auto_increment comment '商品spu id',
    store_id int not null comment '店铺id,参考店铺表',
    category_id int not null comment '分类id',
    cate_ids varchar(255) not null comment '分类的id集合表如: 0/1/3',
    brand_id int not null  comment '品牌id',
    name varchar(50) not null comment '商品名或商品主标题',
    sub_title varchar(255) default null comment '商品spu的副标题',
    main_img  varchar(255) not null  comment '商品主图',
    promotion_type tinyint not null default 0 comment '促销类型 0-无促销 1-抢购 2-限时折扣',
    pay_num int  default 0 comment '付款人数',
    evaluate_num int default 0 comment '评价数量',
    freight decimal(10,2) default 0 comment '运费,0-包邮,免运费',
    state tinyint not null default 1 comment '0-下架(商家行为), 1-在售,10-违规被禁止售卖(管理员行为),一旦禁止售卖则无法上架',
    state_remark varchar(255) default null comment '违规原因',
    verify tinyint default 0 comment '商品审核 1-通过，0-未通过，10-审核中',
    verify_remark varchar(255) default null comment '审核不通过原因',
    pack_list varchar(255) default null comment '包装清单',
    after_sell varchar(255) default null comment '售后服务',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '商品spu表' charset utf8;


/* spu 详情表 ,和 商品spu表 一对一的关系,没有主健,体现对表的垂直字段拆分,避免大数据的频繁读写,提高io性能*/
create table sr_good_spu_detail(
    spu_id int unique key not null comment '商品spu_id ,参考商品spu 表',
    sub_img  text not null comment '商品副图,一个json 数组的字符串 [{url:xxxx.png,isMain:true},{}]',
    detail_desc text default null comment '商品描述详情,是一段html富文本',
    collect_num int default 0 comment '商品收藏数量',
    -- 通用 spu 规格参数的值
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '商品spu详情表' charset utf8;



-- spu 规格参数值表
drop table if exists sr_spu_good_spec_value;
create table sr_spu_good_spec_value (
    id int primary key auto_increment comment '通用的规格参数值的id',
    spec_value varchar(255) not null comment '规格参数值,当参数名规定了 numeric 的时候表示是可以转换为数值类型',
    spu_id  int not null  comment '商品spu_id',
    -- 以下都是快照字段
    spec_item_id int not null comment '规格参数名id',
    spec_item_name varchar(20) not null comment '规格参数健值',
    category_id int not null comment '产品分类id',
    group_id int  not null comment '规格组id',
    spec_type  varchar(20) not null comment '规格值的类型, num-数值类型 , enum 枚举类型 ,str-文本类型,images-图片url地址如xxx.png;xxx.png',
    enum_options varchar(1000) comment '如果是枚举类型的话,其各个枚举值,以逗号分割',
    unit varchar(20) default null comment '在为数值类型的时候的单位,比如12mm中的mm',
    is_necessary tinyint default 1 comment '是否必填,0-不是, 1-是' ,
    -- 附带信息
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '商品spu规格值表' charset utf8;


/*spu 下有多个 商品的sku, 一对多的关系 ,sku表*/
drop table  if exists sr_good_sku;
create table sr_good_sku(
    id int primary key auto_increment comment '商品sku id',
    spu_id int not null comment '商品的spu id ,spu 和 sku 是一对多关系',
    sku_num varchar(50) unique key not null comment '商品sku 编码',
    collect_num int default 0 comment '商品sku收藏数量',
    name varchar(255) not null comment '商品的名字,或则标题',
    main_image varchar(255) not null comment '具体的商品的图片',
    price decimal(10,2) not null comment '商品价格',
    promotion_price decimal(10,2)  comment '促销价格',
    market_price decimal(10,2) comment '市场价格',
    status tinyint not null  default 0 comment '0- 商品有效,-1 商品无效',
     -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
)comment '商品的sku 表,具体到某一款商品' charset utf8 ;


drop table  if exists sr_good_sku_detail;
create table sr_good_sku_detail(
    sku_id int unique key not null comment '商品sku_id ,参考商品sku 表',
    sub_img  text  comment '商品副图,一个json 数组的字符串 xxxx.png;xxxx.png',
    detail_desc text default null comment '商品描述详情,是一段html富文本',
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    -- 附带信息
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
);


/* 商品sku 库存表 同sku 表是一对一关系  */
drop table  if exists sr_good_sku_stock;
create table sr_good_sku_stock(
    sku_id int unique key comment '参考商品的sku 表,和sku表一对一的关系',
    stock int not null  default 0 comment '商品的库存总量',
    stock_alarm int not null  default 0 comment '库存警戒值',
    -- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'
) comment '商品sku库存表' charset utf8;


-- sku规格参数值表
drop table  if exists sr_sku_good_spec_value;
create table sr_sku_good_spec_value (
     id int primary key auto_increment comment '通用的规格参数值的id',
     spec_value varchar(255) not null comment '规格参数值,当参数名规定了 numeric 的时候表示是可以转换为数值类型',
     sku_id  int not null  comment '商品sku_id',
    -- 以下都是快照字段
     spec_item_id int not null comment '规格参数名id',
     spec_item_name varchar(20) not null comment '规格参数健值',
     category_id int not null comment '产品分类id',
     group_id int  not null comment '规格组id',
     spec_type  varchar(20) not null comment '规格值的类型, num-数值类型 , enum 枚举类型 ,str-文本类型,images-图片url地址如xxx.png;xxx.png',
     enum_options varchar(1000) comment '如果是枚举类型的话,其各个枚举值,以逗号分割',
     unit varchar(20) default null comment '在为数值类型的时候的单位,比如12mm中的mm',
     is_necessary tinyint default 1 comment '是否必填,0-不是, 1-是' ,
    -- 附带信息
     create_user int not null comment '创建人的id',
     update_user int not null comment '更新人的id',
     create_time datetime not null comment '创建时间',
     update_time datetime not null comment '更新时间'
)comment '商品sku规格值表' charset utf8;



/*后期会面临的一个问题是, 一个参数是属于spu 的参数 ,还是 sku 的参数 ,比如工位的经纬度 ???? */
--  ---------------------------------------------------------------------------------
