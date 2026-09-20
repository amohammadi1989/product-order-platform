package com.cln.product.service;

import com.cln.product.dto.res.ProductRes;
import com.cln.product.exception.ProductNotFoundException;
import com.cln.product.mapper.ProductMapper;
import com.cln.product.repositoriy.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Ali Mohammadi
 */
@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;
  public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }
  public List<ProductRes> getProducts() {
    var lists = productRepository.findAll();
    return lists.stream().map(productMapper::toDto).toList();
  }
  public ProductRes getProduct(Long id) {
    return productRepository.findById(id).map(productMapper::toDto)
        .orElseThrow(() -> new ProductNotFoundException(id));
  }
}
