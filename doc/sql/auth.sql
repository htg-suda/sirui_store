-- oauth_access_token：访问令牌
-- oauth_refresh_token：更新令牌
-- oauth_client_details：客户端信息
-- oauth_code：授权码
-- oauth_approvals：授权记录
-- oauth_client_token  比较特殊不用于Provider，是客户端用的

/*参考文档  http://www.ruanyifeng.com/blog/2014/05/oauth_2_0.html*/
/* https://www.cnblogs.com/Irving/p/9306008.html */
/*https://www.cnblogs.com/xingxueliao/p/5911292.html*/


/*http://blog.didispace.com/spring-security-oauth2-xjf-1/*/
/*http://blog.didispace.com/spring-security-oauth2-xjf-2/*/
/*http://blog.didispace.com/spring-security-oauth2-xjf-3/*/


/* https://rensanning.iteye.com/blog/2386553  spring oauth2 的自定义*/


/* https://blog.csdn.net/fanbojiayou/article/details/79323315  坑   */
create database store_auth charset utf8;
use store_auth;


DROP TABLE IF EXISTS `oauth_access_token`;

CREATE TABLE `oauth_access_token`
(
    `token_id`          varchar(256) DEFAULT NULL, -- MD5加密的access_token的值
    `token`             blob,                      -- OAuth2AccessToken.java对象序列化后的二进制数据
    `authentication_id` varchar(48) NOT NULL,      -- MD5加密过的username,client_id,scope
    `user_name`         varchar(256) DEFAULT NULL, -- 登录的用户名
    `client_id`         varchar(256) DEFAULT NULL, -- 客户端ID
    `authentication`    blob,                      -- OAuth2Authentication.java对象序列化后的二进制数据
    `refresh_token`     varchar(256) DEFAULT NULL, -- MD5加密果的refresh_token的值
    PRIMARY KEY (`authentication_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


set session sql_mode =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals`
(
    `userId`         varchar(256)       DEFAULT NULL,                                          -- 登录的用户名
    `clientId`       varchar(256)       DEFAULT NULL,                                          -- 客户端ID
    `scope`          varchar(256)       DEFAULT NULL,                                          -- 申请的权限
    `status`         varchar(10)        DEFAULT NULL,                                          -- 状态（Approve或Deny）
    `expiresAt`      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 过期时间
    `lastModifiedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'                          -- 最终修改时间
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



DROP TABLE IF EXISTS `oauth_client_details`;

CREATE TABLE `oauth_client_details`
(
    `client_id`               varchar(48) NOT NULL,       -- 客户端ID
    `resource_ids`            varchar(256)  DEFAULT NULL, -- 资源ID集合,多个资源时用逗号(,)分隔
    `client_secret`           varchar(256)  DEFAULT NULL, -- 客户端密匙
    `scope`                   varchar(256)  DEFAULT NULL, -- 客户端申请的权限范围
    `authorized_grant_types`  varchar(256)  DEFAULT NULL, -- 客户端支持的grant_type
    `web_server_redirect_uri` varchar(256)  DEFAULT NULL, -- 重定向URI
    `authorities`             varchar(256)  DEFAULT NULL, -- 客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔
    `access_token_validity`   int(11)       DEFAULT NULL, -- 访问令牌有效时间值(单位:秒)
    `refresh_token_validity`  int(11)       DEFAULT NULL, -- 更新令牌有效时间值(单位:秒)
    `additional_information`  varchar(4096) DEFAULT NULL, -- 预留字段
    `autoapprove`             varchar(256)  DEFAULT NULL, -- 用户是否自动Approval操作
    PRIMARY KEY (`client_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



DROP TABLE IF EXISTS `oauth_client_token`;

CREATE TABLE `oauth_client_token`
(
    `token_id`          varchar(256) DEFAULT NULL, -- MD5加密的access_token的值
    `token`             blob,                      -- OAuth2AccessToken.java对象序列化后的二进制数据
    `authentication_id` varchar(48) NOT NULL,      -- MD5加密过的username,client_id,scope
    `user_name`         varchar(256) DEFAULT NULL, -- 登录的用户名
    `client_id`         varchar(256) DEFAULT NULL, -- 客户端ID
    PRIMARY KEY (`authentication_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code`
(
    `code`           varchar(256) DEFAULT NULL, -- 授权码(未加密)
    `authentication` blob                       -- AuthorizationRequestHolder.java对象序列化后的二进制数据
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`
(
    `token_id`       varchar(256) DEFAULT NULL, -- MD5加密过的refresh_token的值
    `token`          blob,                      -- OAuth2RefreshToken.java对象序列化后的二进制数据
    `authentication` blob                       -- OAuth2Authentication.java对象序列化后的二进制数据
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

