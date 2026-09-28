package com.cln.product.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Ali Mohammadi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryNotFoundException extends RuntimeException{
  private String msg;
  private Integer code;
  public CategoryNotFoundException(Long id) {
    super("Category not found with id:" + id);
    var msg="Category not found with id:" + id;
    this.msg=msg;
    this.code=-200;
  }
  public CategoryNotFoundException(String msg,Integer code) {
    super("Category not found with id:" + code);
    this.msg=msg;
    this.code=code;
  }
}
