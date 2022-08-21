package com.dxw.service;

import com.dxw.common.Page;
import com.dxw.dto.TagAddModifyRequest;
import com.dxw.dto.TagQueryRequest;
import com.dxw.vo.TagVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagServiceTest {
    @Autowired
    private TagService tagService;

    @Test
    public void testAddTag() throws Exception {
        TagAddModifyRequest addModifyRequest = new TagAddModifyRequest();
        addModifyRequest.setName("测试2");
        Long id = tagService.addTag(addModifyRequest);
        TagQueryRequest queryRequest = new TagQueryRequest();
        queryRequest.setId(id);
        TagVO tagVO = tagService.getTagById(queryRequest);
        Assert.assertEquals(addModifyRequest.getName(), tagVO.getName());
    }

    @Test
    public void testPage() throws Exception {
        TagQueryRequest tagQueryRequest = new TagQueryRequest();
        tagQueryRequest.setPage(Page.of(0,2));
        Page<TagVO> page = tagService.getTagPage(tagQueryRequest);
        System.out.println(page);
        tagQueryRequest.setName("测试2");
        page = tagService.getTagPage(tagQueryRequest);
        System.out.println(page);
    }
}