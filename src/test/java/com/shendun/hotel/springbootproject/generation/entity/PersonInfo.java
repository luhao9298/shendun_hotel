package com.shendun.hotel.springbootproject.generation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class PersonInfo extends Model<PersonInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 身份证号
     */
    private String identifyid;

    /**
     * 所住房间号
     */
    private String roomid;

    /**
     * 入住时间
     */
    private Date acctime;

    /**
     * 入住天数
     */
    private Integer accdays;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 是否入住，1为在住，0为退房
     */
    private Integer isacc;

    /**
     * 退房时间
     */
    private Date checkouttime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
