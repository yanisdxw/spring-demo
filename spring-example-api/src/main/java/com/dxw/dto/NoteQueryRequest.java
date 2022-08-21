package com.dxw.dto;

import lombok.Data;

@Data
public class NoteQueryRequest {
    private Long id;
    private String createUserId;
}
