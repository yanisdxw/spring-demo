package com.dxw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Tag {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 标签名称
     */
    private String name;
    /**
     * 是否为根标签
     */
    private byte isRoot;
    /**
     * 父标签id
     */
    private Long parentId;
    /**
     * 创建者
     */
    private String createUserName;

    /**
     * 创建者id
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
