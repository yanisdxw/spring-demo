package com.dxw.controller;

import com.dxw.common.PageParam;
import com.dxw.common.Response;
import com.dxw.dto.NoteAddModifyRequest;
import com.dxw.dto.NoteDeleteRequest;
import com.dxw.dto.NoteQueryRequest;
import com.dxw.service.NoteService;
import com.dxw.vo.NoteVO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("query")
    public Response<PageParam<NoteVO>> queryByPage(@RequestBody NoteQueryRequest request){
        return Response.ofSuccess(noteService.getNoteByPage(request));
    }

    @SneakyThrows
    @RequestMapping("add")
    public Response add(@RequestBody NoteAddModifyRequest request){
        return Response.ofSuccess(noteService.addNote(request));
    }

    @RequestMapping("delete")
    public Response delete(@RequestBody NoteDeleteRequest request){
        noteService.deleteById(request);
        return Response.ofSuccess();
    }

}
