package com.team.service.impl;

import com.team.dao.DataDictionaryMapper;
import com.team.domain.DataDictionary;
import com.team.domain.DataDictionaryExample;
import com.team.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;
    @Override
    public List<DataDictionary> getAppState() {
        DataDictionaryExample dataDictionaryExample=new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = dataDictionaryExample.createCriteria();
        criteria.andTypenameEqualTo("APP状态");
        List<DataDictionary> dataDictionaries = dataDictionaryMapper.selectByExample(dataDictionaryExample);
        return dataDictionaries;
    }

    @Override
    public List<DataDictionary> getAppFlatform() {
        DataDictionaryExample dataDictionaryExample=new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = dataDictionaryExample.createCriteria();
        criteria.andTypenameEqualTo("所属平台");
        List<DataDictionary> dataDictionaries = dataDictionaryMapper.selectByExample(dataDictionaryExample);
        return dataDictionaries;
    }
}
