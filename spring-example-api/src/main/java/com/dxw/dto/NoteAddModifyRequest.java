package com.dxw.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class NoteAddModifyRequest {

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

    /**
     * 标签id
     */
    private List<Long> tagIds;

}
