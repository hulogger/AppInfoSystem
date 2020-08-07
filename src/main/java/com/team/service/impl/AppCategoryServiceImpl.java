package com.team.service.impl;

import com.team.dao.AppCategoryMapper;
import com.team.domain.AppCategory;
import com.team.domain.AppCategoryExample;
import com.team.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {
    @Autowired
    private AppCategoryMapper appCategoryMapper;
    @Override
    public List<AppCategory> getLastclass(Long parentId) {
        AppCategoryExample appCategoryExample=new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        if (parentId==null){
            criteria.andParentidIsNull();
        }else {
            criteria.andParentidEqualTo(parentId);
        }
        return appCategoryMapper.selectByExample(appCategoryExample);
    }
}
