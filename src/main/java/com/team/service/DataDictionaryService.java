package com.team.service;

import com.team.domain.DataDictionary;

import java.util.List;

public interface DataDictionaryService {
    List<DataDictionary> getAppState();

    List<DataDictionary> getAppFlatform();
}
