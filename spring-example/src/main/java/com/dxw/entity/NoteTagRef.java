package com.dxw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class NoteTagRef {

    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 标签id
     */
    private Long tagId;
    /**
     * 笔记id
     */
    private Long NoteId;
    /**
     * 创建时间
     */
    private Date createTime;
}
