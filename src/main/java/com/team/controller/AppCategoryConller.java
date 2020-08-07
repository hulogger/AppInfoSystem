package com.team.controller;

import com.team.domain.AppCategory;
import com.team.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AppCategoryConller {
    @Autowired
    private AppCategoryService appCategoryService;

    @RequestMapping("/getAppSuperclassData")
    @ResponseBody
    public List<AppCategory> getAppSuperclassData(String parentId){
        if (parentId.isEmpty()||parentId==null){
            return appCategoryService.getLastclass(null);
        }
        return appCategoryService.getLastclass(Long.valueOf(parentId));
    }
}
