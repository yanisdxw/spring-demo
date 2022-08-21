package com.dxw.dto;

import lombok.Data;

@Data
public class TagAddModifyRequest {
    private Long id;
    private String name;
    private Long parentId;
}
