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

  @Transactional
  public ProductRes createProduct(ProductReq productReq) {
    productRepository.findBySku(productReq.getSku()).ifPresent(product -> {
      throw new ProductFoundException(product.getSku());
    });
    var entities = productMapper.toEntity(productReq);
    return productMapper.toDto(productRepository.save(entities));
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  @Transactional
  public ProductRes updateProduct(ProductReq productReq) {
    var product = productRepository.findById(productReq.getId())
        .orElseThrow(() -> new RecordNotFoundException(productReq.getId()));
    product.setActive(productReq.getActive());
    product.setDescription(productReq.getDescription());
    product.setStockQuantity(productReq.getStockQuantity());
    product.setPrice(productReq.getPrice());
    return productMapper.toDto(product);
  }
}
