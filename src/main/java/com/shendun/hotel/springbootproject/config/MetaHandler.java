package com.shendun.hotel.springbootproject.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName MetaHandler
 * @Description 处理新增和更新的基础数据填充，配合BaseEntity和MyBatisPlusConfig使用
 * @Author lh
 * @Date 2019/12/3 17:28
 * @Version 1.0
 **/
@Component
public class MetaHandler implements MetaObjectHandler {

    /**
     * 新增数据执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "create_time", LocalDateTime.class, LocalDateTime.now());
    }

    /**
     * 更新数据执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "update_time", LocalDateTime.class, LocalDateTime.now());
    }

}