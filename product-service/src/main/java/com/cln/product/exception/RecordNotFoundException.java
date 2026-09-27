package com.cln.product.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Ali Mohammadi
 */
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class RecordNotFoundException extends RuntimeException{
  private String msg;
  private Integer code;
  public RecordNotFoundException(Long id) {
    super("Product not found with id:" + id);
    var msg="Product not found with id:" + id;
    this.msg=msg;
    this.code=-210;
  }
  public RecordNotFoundException(String msg,Integer code) {
    super(msg);
    this.msg=msg;
    this.code=code;
  }
}
