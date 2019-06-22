package com.htg.seller.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class CommonFieldFillHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        log.info("insert start fill");
        //   if (metaObject.getValue("updateTime") == null || StringUtils.isEmpty(metaObject.getValue("updateTime").toString())) {
        setFieldValByName("updateTime", new Date(), metaObject);
        // }

        //  if (metaObject.getValue("createTime") == null || StringUtils.isEmpty(metaObject.getValue("createTime").toString())) {
        setFieldValByName("createTime", new Date(), metaObject);
        //}

        setFieldValByName("updateUser", 0, metaObject);
        setFieldValByName("createUser", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        log.info("update start fill");
        setFieldValByName("updateTime", new Date(), metaObject);

        setFieldValByName("updateUser", 0, metaObject);
    }

}
