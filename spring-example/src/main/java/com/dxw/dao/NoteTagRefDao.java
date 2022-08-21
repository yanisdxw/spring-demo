package com.dxw.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dxw.entity.NoteTagRef;
import com.dxw.mapper.NoteTagRefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class NoteTagRefDao {

    @Autowired
    private NoteTagRefMapper mapper;

    public void insert(Long noteId, Long tagId){
        NoteTagRef ref = new NoteTagRef();
        ref.setNoteId(noteId);
        ref.setTagId(tagId);
        ref.setCreateTime(new Date());
        mapper.insert(ref);
    }

    public void insertBatch(Long noteId, Set<Long> tagIds){
        for(Long tagId:tagIds){
            insert(noteId, tagId);
        }
    }

    public void delete(Long noteId, Long tagId){
        QueryWrapper<NoteTagRef> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("notd_id",noteId);
        queryWrapper.eq("tag_id",tagId);
        mapper.delete(queryWrapper);
    }

    public void deleteBatch(Long noteId, Set<Long> tagIds){
        for(Long tagId:tagIds){
            delete(noteId,tagId);
        }
    }

    public List<Long> getTagIdsByNoteId(Long noteId){
        QueryWrapper<NoteTagRef> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("note_id", noteId);
        List<NoteTagRef> refs = mapper.selectList(queryWrapper);
        return refs.stream().map(i->i.getTagId()).distinct().collect(Collectors.toList());
    }

}
