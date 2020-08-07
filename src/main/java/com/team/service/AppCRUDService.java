package com.team.service;


import com.github.pagehelper.PageInfo;
import com.team.domain.AppCondition;
import com.team.domain.AppInfo;

import java.util.List;

public interface AppCRUDService {
    Integer appinfoadd(AppInfo appinfo);

    AppInfo getAppInfoById(Long id);

    Integer updateAppInfo(AppInfo appInfo);

    Integer delApp(Long id);

    PageInfo<AppInfo> getAppInfo(AppCondition appCondition);

    AppInfo selectAppInfoToCheck(Long id);

    int updateAppState(Long id,Long state);
}
