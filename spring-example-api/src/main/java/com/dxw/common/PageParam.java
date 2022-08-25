package com.dxw.common;

import lombok.Data;

import java.util.List;

@Data
public class PageParam<T> {
    private long no;
    private long size;
    private long total;
    private List<T> datas;

    private PageParam(){

    }

    public static PageParam of(int no, int size){
        PageParam page = new PageParam();
        page.setNo(no);
        page.setSize(size);
        return page;
    }


}
