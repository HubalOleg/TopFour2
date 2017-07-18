package com.example.hubaloleg.topfour.data.mapper.venues;

import com.example.hubaloleg.topfour.data.mapper.IconMapper;
import com.example.hubaloleg.topfour.data.remote.model.entity.venues.CategoryEntity;
import com.example.hubaloleg.topfour.domain.model.venues.Category;

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

    public List<Category> transormList(List<CategoryEntity> categoryEntityList) {
        List<Category> categoryList = new ArrayList<>();

        for (CategoryEntity categoryEntity : categoryEntityList) {
            categoryList.add(transform(categoryEntity));
        }

        return categoryList;
    }

    public Category transform(CategoryEntity categoryEntity) {
        return new Category(
                categoryEntity.getId(),
                categoryEntity.getName(),
                mIconMapper.transform(categoryEntity.getIconEntity()));
    }
}
