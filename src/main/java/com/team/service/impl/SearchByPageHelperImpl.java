package com.team.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.dao.AppInfoMapper;
import com.team.domain.AppCondition;
import com.team.domain.AppInfo;
import com.team.service.SearchByHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchByPageHelperImpl implements SearchByHelperService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Override
    public  PageInfo<AppInfo> searchAppByP(AppCondition appCondition) {
        PageHelper.startPage(appCondition.getPageIndex(),appCondition.getPageSize());
        List<AppInfo> appInfoList = appInfoMapper.searchAppByPageHelper(appCondition);
        return new PageInfo<>(appInfoList);
    }
}
