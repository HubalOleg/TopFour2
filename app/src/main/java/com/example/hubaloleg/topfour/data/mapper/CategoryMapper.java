package com.example.hubaloleg.topfour.data.mapper;

import android.util.Log;

import com.example.hubaloleg.topfour.data.cache.db.CategoryDB;
import com.example.hubaloleg.topfour.data.remote.model.entity.CategoryEntity;
import com.example.hubaloleg.topfour.domain.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hubaloleg on 12.07.17.
 */

public class CategoryMapper {

    private final IconMapper mIconMapper;

    public CategoryMapper(IconMapper iconMapper) {
        mIconMapper = iconMapper;
    }

    public List<CategoryDB> transformApiList(List<CategoryEntity> categoryEntityList) {
        List<CategoryDB> categoryList = new ArrayList<>();

        for (CategoryEntity categoryEntity : categoryEntityList) {
            categoryList.add(transformApi(categoryEntity));
        }

        return categoryList;
    }

    public CategoryDB transformApi(CategoryEntity categoryEntity) {
        return new CategoryDB(
                categoryEntity.getId(),
                categoryEntity.getName(),
                mIconMapper.transformApi(categoryEntity.getIconEntity()));
    }

    public List<Category> transformDBList(List<CategoryDB> categoryDBList) {
        List<Category> categoryList = new ArrayList<>();

        for (CategoryDB categoryDB : categoryDBList) {
            categoryList.add(transformDB(categoryDB));
        }

        return categoryList;
    }

    public Category transformDB(CategoryDB categoryDB) {
        return new Category(
                categoryDB.getId(),
                categoryDB.getName(),
                mIconMapper.transformDB(categoryDB.getIconDB()));
    }
}
