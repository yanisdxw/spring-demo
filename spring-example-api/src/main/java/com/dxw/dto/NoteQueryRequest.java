package com.dxw.dto;

import com.dxw.common.PageParam;
import lombok.Data;

@Data
public class NoteQueryRequest {
    private Long id;
    private Long createUserId;
    private String subject;
    private PageParam page;
}
