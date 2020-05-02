package com.universe.starry.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhoutianxiang
 * @since 2020-05-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("system_log")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 逻辑删除位，0未删除
     */
    private Integer status;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;

    /**
     * 操作人id
     */
    private Integer operateUserId;

    /**
     * 模块类型
     */
    private String modelType;

    /**
     * 操作类型
     */
    private String operateType;

    /**
     * 操作对象
     */
    private String operateObject;

    /**
     * 操作结果
     */
    private String operateResult;

    /**
     * 持续时间
     */
    private Integer timeSpan;

    /**
     * 操作IP地址
     */
    private String operateIp;

    /**
     * 操作mac地址
     */
    private String operateMac;

    /**
     * 描述
     */
    private String description;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
