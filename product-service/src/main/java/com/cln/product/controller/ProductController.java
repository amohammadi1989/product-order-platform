package com.cln.product.controller;

import com.cln.product.dto.req.ProductReq;
import com.cln.product.dto.res.ProductRes;
import com.cln.product.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ali Mohammadi
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public ProductRes getProduct(@PathVariable("id") Long id) {
    return productService.getProduct(id);
  }

  @GetMapping
  public List<ProductRes> getProducts() {
    return productService.getProducts();
  }

  @PutMapping
  public ResponseEntity<ProductRes> updateProduct(@Valid
  @RequestBody ProductReq productReq) {
    return ResponseEntity.ok(productService.updateProduct(productReq));
  }

  @PostMapping
  public ResponseEntity<ProductRes> createProduct(@Valid @RequestBody ProductReq productReq) {
    return ResponseEntity.ok(productService.createProduct(productReq));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
    productService.deleteProduct(id);
    return ResponseEntity.ok("successfully product with id " + id + " is delete");
  }
}
