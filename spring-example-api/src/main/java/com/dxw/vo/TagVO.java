package com.dxw.vo;

import lombok.Data;
import sun.security.krb5.internal.ccache.Tag;

import java.util.List;


@Data
public class TagVO {
    /**
     * 主键
     */
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
     * 子标签
     */
    private List<Tag> children;

}
