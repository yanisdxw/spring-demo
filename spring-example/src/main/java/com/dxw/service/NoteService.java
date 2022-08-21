package com.dxw.service;

import com.dxw.dao.NoteDao;
import com.dxw.dao.NoteTagRefDao;
import com.dxw.dao.TagDao;
import com.dxw.dto.NoteAddModifyRequest;
import com.dxw.entity.Note;
import com.dxw.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class NoteService {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private NoteTagRefDao noteTagRefDao;

    @Transactional(rollbackFor = Exception.class)
    public Long addNote(NoteAddModifyRequest request) throws Exception {
        if(request.getId()==null){
            Note note = new Note();
            note.setContext(request.getContext());
            note.setCreateTime(new Date());
            note.setUpdateTime(new Date());
            note.setCreateUserId(1L);
            note.setSource(request.getSource());
            note.setSubject(request.getSubject());
            noteDao.insert(note);
            List<Long> tagIds = request.getTagIds();
            for(Long id:tagIds){
                Tag tag = tagDao.getById(id);
                if(tag==null){
                    throw new Exception(String.format("tag 【%s】不存在",id));
                }
                noteTagRefDao.insert(note.getId(),id);
            }
            return note.getId();
        }else {
            Note noteOld = noteDao.getById(request.getId());
            List<Long> tagsRefOld = noteTagRefDao.getTagIdsByNoteId(request.getId());
            Set<Long> tagsOld = new HashSet<>(tagsRefOld);
            if(noteOld==null){
                throw new Exception(String.format("note【%s】不存在",request.getId()));
            }
            Note note = new Note();
            note.setId(request.getId());
            note.setContext(request.getContext());
            note.setUpdateTime(new Date());
            note.setCreateUserId(1L);
            note.setSource(request.getSource());
            note.setSubject(request.getSubject());
            List<Long> tagIds = request.getTagIds();
            for(Long id:tagIds){
                Tag tag = tagDao.getById(id);
                if(tag==null){
                    throw new Exception(String.format("tag 【%s】不存在",id));
                }
            }
            Set<Long> addTags = new HashSet<>(tagIds);
            addTags.removeAll(tagsOld);
            noteTagRefDao.insertBatch(note.getId(),addTags);
            Set<Long> delTags = new HashSet<>(tagsOld);
            delTags.retainAll(tagIds);
            noteTagRefDao.deleteBatch(note.getId(),delTags);
            return note.getId();
        }
    }
}
