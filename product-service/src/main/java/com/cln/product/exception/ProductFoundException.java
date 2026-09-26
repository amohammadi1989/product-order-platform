package com.cln.product.exception;

/**
 * @author Ali Mohammadi
 */
public class ProductFoundException extends RuntimeException{
  public ProductFoundException(String sku) {
    super("Product already exists with SKU: " + sku);
  }
}
