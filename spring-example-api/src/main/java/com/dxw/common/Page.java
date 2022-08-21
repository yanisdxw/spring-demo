package com.dxw.common;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private int no;
    private int size;
    private long total;
    private List<T> datas;

    private Page(){

    }

    public static Page of(int no, int size){
        Page page = new Page();
        page.setNo(no);
        page.setSize(size);
        return page;
    }

}
