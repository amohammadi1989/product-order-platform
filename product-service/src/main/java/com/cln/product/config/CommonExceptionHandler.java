package com.cln.product.config;

import com.cln.product.dto.res.ErrorResDto;
import com.cln.product.exception.ProductFoundException;
import com.cln.product.exception.ProductNotFoundException;
import com.cln.product.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Ali Mohammadi
 */
@RestControllerAdvice
public class CommonExceptionHandler {

  @ExceptionHandler(ProductFoundException.class)
  public ResponseEntity<ErrorResDto> handleProductFoundException(ProductFoundException exp) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ErrorResDto.builder().msg(exp.getMsg()).code(exp.getCode()).build());
  }

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<ErrorResDto> handleProductNotFoundException(ProductNotFoundException exp) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(ErrorResDto.builder().msg(exp.getMsg()).code(exp.getCode()).build());
  }

  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<ErrorResDto> handleRecordNotFoundException(RecordNotFoundException exp) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(ErrorResDto.builder().msg(exp.getMsg()).code(exp.getCode()).build());
  }
}
