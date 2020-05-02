package com.universe.starry.base.entity;

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
@TableName("base_user")
public class User extends Model<User> {

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人id
     */
    private Integer createUserId;

    /**
     * 用户编码，登录名
     */
    private String userCode;

    /**
     * 名称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 所属机构id
     */
    private Integer orgId;

    /**
     * 所属部门id
     */
    private Integer deptId;

    /**
     * 描述
     */
    private String description;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 用户状态，0正常
     */
    private Integer userStatus;

    /**
     * session版本号，时间戳
     */
    private Integer sessionVersion;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
