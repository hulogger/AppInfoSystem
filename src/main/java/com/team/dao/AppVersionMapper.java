package com.team.dao;

import com.team.domain.AppInfo;
import com.team.domain.AppVersion;
import com.team.domain.AppVersionExample;
import java.util.List;

public interface AppVersionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    List<AppVersion> selectByExample(AppVersionExample example);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    List<AppVersion> selectByPrimaryKey2(Long id);

    AppVersion selectBastVersion(Long appId);
}