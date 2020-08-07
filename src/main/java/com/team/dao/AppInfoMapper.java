package com.team.dao;

import com.github.pagehelper.PageInfo;
import com.team.domain.AppCondition;
import com.team.domain.AppInfo;
import com.team.domain.AppInfoExample;
import com.team.domain.AppVersion;

import java.util.List;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    List<AppInfo> selectByExample(AppInfoExample example);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);

    List<AppInfo> searchAppByPageHelper(AppCondition appCondition);

    AppInfo selectOneMoreById(Long id);

    int delAppVersionByAppId(Long appId);

    List<AppInfo> getAppInfo(AppCondition appCondition);

    AppInfo selectAppInfoToCheck(Long id);

    int appChecked(Long state,Long id);
}