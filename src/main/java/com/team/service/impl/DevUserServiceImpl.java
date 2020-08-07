package com.team.service.impl;

import com.team.dao.DevUserMapper;
import com.team.domain.DevUser;
import com.team.domain.DevUserExample;
import com.team.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    private DevUserMapper devUserMapper;
    @Override
    public DevUser login(String username, String password) {

        DevUserExample devUserExample=new DevUserExample();
        DevUserExample.Criteria userExampleCriteria = devUserExample.createCriteria();
        userExampleCriteria.andDevcodeEqualTo(username);
        userExampleCriteria.andDevpasswordEqualTo(password);
        List<DevUser> devUsers = devUserMapper.selectByExample(devUserExample);
        if(devUsers!=null && devUsers.size()!=0){
            return devUsers.get(0);  //返回信息
        }
        return null;
    }
}
