package com.cln.product.mapper;

import com.cln.product.dto.res.CategoryResDto;
import com.cln.product.enity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  CategoryResDto toDto(CategoryEntity entity);
}
