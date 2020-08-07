package com.team.service;

import com.team.domain.AppInfo;
import com.team.domain.AppVersion;

import java.util.List;

public interface AppVersionService {
    List<AppVersion> getAppVersionInfo(Long id);

    int addAppVersion(AppVersion appVersion);

    AppVersion getBastVersion(Long appId);
}
