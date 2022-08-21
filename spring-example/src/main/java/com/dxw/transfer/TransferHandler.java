package com.dxw.transfer;

import com.dxw.dto.NoteAddModifyRequest;
import com.dxw.dto.TagAddModifyRequest;
import com.dxw.entity.Note;
import com.dxw.entity.Tag;
import com.dxw.vo.NoteVO;
import com.dxw.vo.TagVO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TransferHandler {

    @PostConstruct
    public void init(){
        TransferUtil.register(Note.class, NoteVO.class, (note, noteVO)->{

        });
        TransferUtil.register(NoteVO.class, Note.class, (noteVO, note)->{

        });
        TransferUtil.register(NoteAddModifyRequest.class, Note.class, (request, note)->{

        });
        TransferUtil.register(Tag.class, TagVO.class, (tag, tagVO)->{

        });
        TransferUtil.register(TagVO.class, Tag.class, (tagVO, tag)->{

        });
        TransferUtil.register(TagAddModifyRequest.class, Tag.class, (request, tag)->{
            tag.setCreateUserId(1L);
            tag.setCreateUserName("test");
            tag.setIsRoot((byte) 1);
            tag.setName(request.getName());
            tag.setParentId(request.getParentId());
        });
    }


}
