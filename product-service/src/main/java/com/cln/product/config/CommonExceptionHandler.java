package com.cln.product.config;

import com.cln.product.dto.res.ErrorResDto;
import com.cln.product.dto.res.ValidationErrorDto;
import com.cln.product.exception.ProductFoundException;
import com.cln.product.exception.ProductNotFoundException;
import com.cln.product.exception.RecordNotFoundException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResDto> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex) {
    List<ValidationErrorDto> errors = ex
        .getBindingResult()
        .getFieldErrors()
        .stream()
        .map(error -> ValidationErrorDto.builder() .field(error.getField()) .message(error.getDefaultMessage()) .build()) .toList(); ErrorResDto response = ErrorResDto.builder() .msg("Validation failed") .code(HttpStatus.BAD_REQUEST.value()) .errors(errors) .build();
        return ResponseEntity .badRequest() .body(response);
  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResDto> handleException(
      Exception ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(ErrorResDto.builder().msg(ex.getMessage()).code(-1000).build());
  }
}
