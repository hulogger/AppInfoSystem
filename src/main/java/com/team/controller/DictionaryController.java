package com.team.controller;

import com.google.gson.Gson;
import com.team.domain.DataDictionary;
import com.team.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Dictionary;
import java.util.List;

@Controller
public class DictionaryController {
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @RequestMapping("/getAppStateData")
    @ResponseBody
    public List<DataDictionary> getAppStateData(){
        List<DataDictionary> appState = dataDictionaryService.getAppState();
        return appState;
    }
    @RequestMapping("/getAppFlatformData")
    @ResponseBody
    public List<DataDictionary> getAppFlatForm(){
        return dataDictionaryService.getAppFlatform();
    }
}
