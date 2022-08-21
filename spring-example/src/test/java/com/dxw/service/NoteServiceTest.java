package com.dxw.service;

import com.dxw.dto.NoteAddModifyRequest;
import com.dxw.dto.NoteQueryRequest;
import com.dxw.vo.NoteVO;
import com.google.common.collect.ImmutableList;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceTest {

    @Autowired
    private NoteService noteService;

    @SneakyThrows
    @Test
    public void testInsertAndGet(){
        NoteAddModifyRequest request = new NoteAddModifyRequest();
        request.setContext("hello world!");
        request.setSubject("subject3");
        request.setComment("测试评论");
        request.setSource("book");
        request.setTagIds(ImmutableList.of(3L));
        Long noteId = noteService.addNote(request);
        NoteQueryRequest queryRequest = new NoteQueryRequest();
        queryRequest.setId(noteId);
        NoteVO noteVO = noteService.getNoteById(queryRequest);
        System.out.println(noteVO);
    }

    @SneakyThrows
    @Test
    public void testUpdate(){
        NoteAddModifyRequest request = new NoteAddModifyRequest();
        request.setId(2L);
        request.setContext("hello world!");
        request.setSubject("test subject");
        request.setComment("测试评论");
        request.setSource("book");
        request.setTagIds(ImmutableList.of(2L));

        NoteQueryRequest queryRequest = new NoteQueryRequest();
        queryRequest.setId(request.getId());
        NoteVO noteVO = noteService.getNoteById(queryRequest);
        System.out.println(noteVO);

        noteService.addNote(request);

        noteVO = noteService.getNoteById(queryRequest);
        System.out.println(noteVO);
    }

}