package com.cln.product.service;

import com.cln.product.dto.req.ProductReq;
import com.cln.product.dto.res.ProductRes;
import com.cln.product.exception.ProductFoundException;
import com.cln.product.exception.ProductNotFoundException;
import com.cln.product.exception.RecordNotFoundException;
import com.cln.product.mapper.ProductMapper;
import com.cln.product.repositoriy.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Ali Mohammadi
 */
@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;
  private final CategoryService categoryService;


  public List<ProductRes> getProducts() {
    var lists = productRepository.findAll();
    return lists.stream().map(productMapper::toDto).toList();
  }

  public ProductRes getProduct(Long id) {
    return productRepository.findById(id).map(productMapper::toDto)
        .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @Transactional
  public ProductRes createProduct(ProductReq productReq) {
    validateSkuNotExists(productReq);
    var category = categoryService.getReferenceById(productReq.getCategoryId());
    var product = productMapper.toEntity(productReq);
    product.setCategory(category);
    var savedProduct = productRepository.save(product);
    return productMapper.toDto(savedProduct);
  }

  private void validateSkuNotExists(ProductReq productReq) {
    productRepository.findBySku(productReq.getSku()).ifPresent(product -> {
      throw new ProductFoundException(product.getSku(), -100);
    });
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  @Transactional
  public ProductRes updateProduct(ProductReq productReq) {
    var product = productRepository.findById(productReq.getId())
        .orElseThrow(() -> new RecordNotFoundException(productReq.getId()));
    var category = categoryService.getReferenceById(productReq.getCategoryId());
    productMapper.updateEntity(productReq, product);
    product.setCategory(category);
    return productMapper.toDto(product);
  }
}
