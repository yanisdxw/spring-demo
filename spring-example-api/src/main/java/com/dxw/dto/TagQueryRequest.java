package com.dxw.dto;

import com.dxw.common.PageParam;
import lombok.Data;

@Data
public class TagQueryRequest {
    private Long id;
    private String name;
    private Byte isRoot;
    private Long parentId;
    private PageParam page;
}
