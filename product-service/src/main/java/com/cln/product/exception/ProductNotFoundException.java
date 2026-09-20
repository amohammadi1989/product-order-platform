package com.cln.product.exception;

/**
 * @author Ali Mohammadi
 */
public class ProductNotFoundException extends RuntimeException{
  public ProductNotFoundException(Long id) {
    super("Product not found with id: " + id);
  }
}
