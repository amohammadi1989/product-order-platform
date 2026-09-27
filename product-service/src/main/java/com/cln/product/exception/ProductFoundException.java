package com.cln.product.exception;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Ali Mohammadi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductFoundException extends RuntimeException{
  private String msg;
  private Integer code;
  public ProductFoundException(String msg) {
    super("Product already exists with SKU: " + msg);
    this.msg=msg;
  }
  public ProductFoundException(String msg, Integer code){
    super("Product already exists with SKU: " + msg);
    this.msg=msg;
    this.code=code;
  }
}
