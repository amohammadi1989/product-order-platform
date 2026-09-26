package com.cln.product.exception;

/**
 * @author Ali Mohammadi
 */
public class RecordNotFoundException extends RuntimeException{
  public RecordNotFoundException(Long id) {
    super("Record not found with id: " + id);
  }
}
