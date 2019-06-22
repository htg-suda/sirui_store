drop  database if exists sirui_store_order;
create database sirui_store_order;
use sirui_store_order;

create table sr_order(
    id int primary key auto_increment comment '订单',
    order_sn varchar(30)  unique key not null comment '订单号,时间戳 精确到',
    pay_sn varchar(30) unique key  not null comment '支付单号',
    seller_sn varchar(50)  not null comment '商户编号',

    custom_id int not null comment '用户id,参考用户表',
    order_status tinyint not null default 10  comment '订单状态：0:已取消 10:未付款 20:已付款 30:已发货 40:已收货',
    evaluation_state tinyint not null default 0 comment '评价状态 0：未评价 1：已评价 2:已过期未评价',
    goods_amount decimal(10,2) not null comment '商品订单总价',


    add_time datetime not null comment '订单生成时间',
    payment_time datetime not null comment '付款时间',
    payment_code tinyint not null comment '支付方式 0-货到付款,1-在线支付',
-- 附带信息
    del_flag tinyint default 0 comment '删除状态,0-有效,-1 -删除',
    create_user int not null comment '创建人的id',
    update_user int not null comment '更新人的id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间'

);





