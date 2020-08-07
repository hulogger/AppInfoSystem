package com.team.service.impl;

import com.team.dao.AppVersionMapper;
import com.team.domain.AppInfo;
import com.team.domain.AppVersion;
import com.team.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;

    @Override
    public List<AppVersion> getAppVersionInfo(Long id) {
        return appVersionMapper.selectByPrimaryKey2(id);
    }

    @Override
    public int addAppVersion(AppVersion appVersion) {
        return appVersionMapper.insert(appVersion);
    }

    @Override
    public AppVersion getBastVersion(Long appId) {
        return appVersionMapper.selectBastVersion(appId);
    }
}
