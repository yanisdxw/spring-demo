package com.dxw.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxw.common.PageParam;
import com.dxw.condition.TagCondition;
import com.dxw.dao.TagDao;
import com.dxw.dto.TagAddModifyRequest;
import com.dxw.dto.TagQueryRequest;
import com.dxw.entity.Tag;
import com.dxw.transfer.TransferUtil;
import com.dxw.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagDao tagDao;


    public Long addTag(TagAddModifyRequest request) throws Exception {
        if(request.getId()==null){
            Tag tag = TransferUtil.to(request, Tag.class);
            tag.setCreateTime(new Date());
            tag.setUpdateTime(new Date());
            tagDao.insert(tag);
            return tag.getId();
        }else {
            Tag tagOld = tagDao.getById(request.getId());
            if(tagOld==null){
                throw new Exception(String.format("标签【%s】不存在",request.getId()));
            }
            Tag tag = TransferUtil.to(request, Tag.class);
            tag.setUpdateTime(new Date());
            tagDao.update(tag);
            return tag.getId();
        }
    }

    public TagVO getTagById(TagQueryRequest request){
        Tag tag = tagDao.getById(request.getId());
        TagVO tagVO = TransferUtil.to(tag, TagVO.class);
        return tagVO;
    }

    public PageParam<TagVO> getTagPage(TagQueryRequest request){
        PageParam page = request.getPage();
        Page<Tag> tagPage = new Page<>();
        tagPage.setSize(page.getSize());
        tagPage.setCurrent(page.getNo());
        TagCondition condition = TransferUtil.to(request, TagCondition.class);
        tagPage = tagDao.findListPage(tagPage, condition);
        List<TagVO> tagVOList = TransferUtil.to(tagPage.getRecords(), TagVO.class);
        PageParam<TagVO> tagVOPage = TransferUtil.to(tagPage, PageParam.class);
        tagVOPage.setDatas(tagVOList);
        tagVOPage.setTotal(tagPage.getTotal());
        return tagVOPage;
    }

    public void delete(){

    }

}
