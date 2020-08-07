package com.team.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.dao.AppInfoMapper;
import com.team.dao.AppVersionMapper;
import com.team.domain.AppCondition;
import com.team.domain.AppInfo;
import com.team.service.AppCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppCRUDServiceImpl implements AppCRUDService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Autowired
    private  AppVersionMapper appVersionMapper;
    @Override
    public Integer appinfoadd(AppInfo appinfo) {
        return appInfoMapper.insertSelective(appinfo);
    }

    @Override
    public AppInfo getAppInfoById(Long id) {
        return appInfoMapper.selectOneMoreById(id);
    }

    @Override
    public Integer updateAppInfo(AppInfo appInfo) {
        return appInfoMapper.updateByPrimaryKeySelective(appInfo);
    }

    @Override
    @Transactional
    public Integer delApp(Long id) {
        int i = appInfoMapper.delAppVersionByAppId(id);
        return appInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<AppInfo> getAppInfo(AppCondition appCondition) {
        PageHelper.startPage(appCondition.getPageIndex(),appCondition.getPageSize());
        List<AppInfo> appInfo = appInfoMapper.getAppInfo(appCondition);
        return new PageInfo<AppInfo>(appInfo);
    }

    @Override
    public AppInfo selectAppInfoToCheck(Long id) {
        return appInfoMapper.selectAppInfoToCheck(id);
    }

    @Override
    public int updateAppState(Long id, Long state) {
        AppInfo appInfo=new AppInfo();
        appInfo.setId(id);
        appInfo.setStatus(state);
        return appInfoMapper.updateByPrimaryKeySelective(appInfo);
    }


}
