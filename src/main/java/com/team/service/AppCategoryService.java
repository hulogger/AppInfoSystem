package com.team.service;

import com.team.domain.AppCategory;

import java.util.List;

public interface AppCategoryService {

    List<AppCategory> getLastclass(Long parentId);
}
