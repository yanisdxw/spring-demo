package com.dxw.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class NoteVO {

    /**
     * 主键
     */
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
     * 标签列表
     */
    private List<TagVO> tags;

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
