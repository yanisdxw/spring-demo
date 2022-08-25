package com.dxw.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxw.condition.NoteCondition;
import com.dxw.entity.Note;
import com.dxw.mapper.NoteMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDao {

    @Autowired
    private NoteMapper mapper;

    public void insert(Note note){
        mapper.insert(note);
    }

    public void update(Note note){
        UpdateWrapper<Note> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("id",note.getId());
        mapper.update(note,updateWrapper);
    }

    public Note getById(Long id){
        return mapper.selectById(id);
    }

    public Page<Note> findListPage(Page page, NoteCondition condition){
        QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
        if(condition.getId()!=null) queryWrapper.eq("id",condition.getId());
        if(StringUtils.isNotEmpty(condition.getSubject())) queryWrapper.like("subject",condition.getSubject());
        if(condition.getCreateTimeFloor()!=null) queryWrapper.gt("create_time", condition.getCreateTimeFloor());
        if(condition.getCreateTimeCeiling()!=null) queryWrapper.lt("create_time",condition.getCreateTimeCeiling());
        if(condition.getCreateUserId()!=null) queryWrapper.eq("create_user_id",condition.getCreateUserId());
        return mapper.selectPage(page, queryWrapper);
    }

    public void deleteById(Long id){
        mapper.deleteById(id);
    }

}
