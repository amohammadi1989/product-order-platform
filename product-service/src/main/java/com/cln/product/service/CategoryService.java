package com.cln.product.service;

import com.cln.product.dto.res.CategoryResDto;
import com.cln.product.enity.CategoryEntity;
import com.cln.product.exception.CategoryNotFoundException;
import com.cln.product.mapper.CategoryMapper;
import com.cln.product.repositoriy.CategoryRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Ali Mohammadi
 */
@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;

  public CategoryResDto findById(Long id) {
    return categoryRepository
        .findById(id)
        .map(categoryMapper::toDto)
        .orElseThrow(() -> new CategoryNotFoundException(id));
  }
  public CategoryEntity getReferenceById(Long id) {
    var category = categoryRepository.getReferenceById(id);
    Objects.requireNonNull(category);
    return category;
  }
}
