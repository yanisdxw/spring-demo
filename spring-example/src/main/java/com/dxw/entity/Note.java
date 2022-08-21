package com.dxw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Note {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String context;

    /**
     * 点评
     */
    private String comment;

    /**
     * 来源
     */
    private String source;

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
