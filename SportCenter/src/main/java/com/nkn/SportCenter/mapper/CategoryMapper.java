package com.nkn.SportCenter.mapper;

import org.mapstruct.Mapper;

import com.nkn.SportCenter.dto.request.CategoryRequest;
import com.nkn.SportCenter.entities.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest request);
}
