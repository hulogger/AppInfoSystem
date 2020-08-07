package com.team.service;

import com.team.domain.DevUser;

public interface DevUserService {
    //实现登录
    public DevUser login(String username, String password);
}
