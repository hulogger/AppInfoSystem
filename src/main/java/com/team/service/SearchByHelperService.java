package com.team.service;

import com.github.pagehelper.PageInfo;

import com.team.domain.AppCondition;
import com.team.domain.AppInfo;

import java.util.List;

public interface SearchByHelperService {
        PageInfo<AppInfo> searchAppByP(AppCondition appCondition);
}
