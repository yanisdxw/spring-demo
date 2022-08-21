package com.dxw.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxw.condition.TagCondition;
import com.dxw.entity.Tag;
import com.dxw.mapper.TagMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TagDao {

    @Autowired
    private TagMapper mapper;

    public void insert(Tag tag){
        mapper.insert(tag);
    }

    public void update(Tag tag){
        UpdateWrapper<Tag> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("id",tag.getId());
        mapper.update(tag,updateWrapper);
    }

    public Tag getById(Long id){
        return mapper.selectById(id);
    }

    public Page<Tag> findListPage(Page page, TagCondition condition){
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        if(condition.getId()!=null) queryWrapper.eq("id",condition.getId());
        if(StringUtils.isNotEmpty(condition.getName())) queryWrapper.like("name",condition.getName());
        return mapper.selectPage(page, queryWrapper);
    }

    public void deleteById(Long id){
        mapper.deleteById(id);
    }

}
