package com.shendun.hotel.springbootproject.generation.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lh
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RoomInfo extends Model<RoomInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 房间号
     */
    private String roomid;

    /**
     * 房间类型_双人_单人_三人
     */
    private String roomtype;

    /**
     * 房间在住人数
     */
    private String roomcount;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
