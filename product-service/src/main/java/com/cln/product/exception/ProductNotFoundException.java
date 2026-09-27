package com.cln.product.exception;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Ali Mohammadi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductNotFoundException extends RuntimeException{
  private String msg;
  private Integer code;
  public ProductNotFoundException(Long id) {
    super("Product not found with id:" + id);
    var msg="Product not found with id:" + id;
    this.msg=msg;
    this.code=-200;
  }
  public ProductNotFoundException(String msg,Integer code) {
    super("Product not found with id:" + code);
    this.msg=msg;
    this.code=code;
  }
}
