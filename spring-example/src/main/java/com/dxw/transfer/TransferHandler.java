package com.dxw.transfer;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxw.common.PageParam;
import com.dxw.dao.NoteDao;
import com.dxw.dao.NoteTagRefDao;
import com.dxw.dao.TagDao;
import com.dxw.dto.NoteAddModifyRequest;
import com.dxw.dto.TagAddModifyRequest;
import com.dxw.entity.Note;
import com.dxw.entity.Tag;
import com.dxw.vo.NoteVO;
import com.dxw.vo.TagVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TransferHandler {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private NoteTagRefDao noteTagRefDao;

    @PostConstruct
    public void init(){
        TransferUtil.register(Tag.class, TagVO.class, (tag, tagVO)->{

        });
        TransferUtil.register(TagVO.class, Tag.class, (tagVO, tag)->{

        });
        TransferUtil.register(TagAddModifyRequest.class, Tag.class, (request, tag)->{
            tag.setCreateUserId(1L);
            tag.setCreateUserName("test");
            tag.setIsRoot((byte) 1);
        });
        TransferUtil.register(Note.class, NoteVO.class, (note, noteVO)->{
            Long nodeId = note.getId();
            List<Long> tagIds = noteTagRefDao.getTagIdsByNoteId(nodeId);
            if(CollectionUtils.isNotEmpty(tagIds)){
                List<Tag> tags = tagDao.getByIds(tagIds);
                List<TagVO> tagVOList = TransferUtil.to(tags, TagVO.class);
                noteVO.setTags(tagVOList);
            }
        });
        TransferUtil.register(NoteVO.class, Note.class, (noteVO, note)->{

        });
        TransferUtil.register(NoteAddModifyRequest.class, Note.class, (request, note)->{
            note.setCreateUserId(1L);
            note.setCreateUserName("test");
        });
        TransferUtil.register(Page.class, PageParam.class, ((page, pageParam) -> {
            pageParam.setNo(page.getCurrent());
            pageParam.setSize(page.getSize());
            pageParam.setTotal(page.getTotal());
            pageParam.setDatas(page.getRecords());
        }));
        TransferUtil.register(PageParam.class, Page.class, ((pageParam, page) -> {
            page.setSize(pageParam.getSize());
            page.setCurrent(pageParam.getNo());
        }));
    }


}
