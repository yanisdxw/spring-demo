package com.dxw.dto;

import com.dxw.common.Page;
import lombok.Data;

@Data
public class TagQueryRequest {
    private Long id;
    private String name;
    private Byte isRoot;
    private Long parentId;
    private Page page;
}
