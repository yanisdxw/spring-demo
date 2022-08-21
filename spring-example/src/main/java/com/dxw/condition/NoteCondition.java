package com.dxw.condition;

import lombok.Data;

import java.util.Date;

@Data
public class NoteCondition {

    private Long id;
    /**
     * 主题
     */
    private String subject;

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
    private Date createTimeFloor;

    private Date createTimeCeiling;

}
