package com.cln.product.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Ali Mohammadi
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorDto {

  private String field;
  private String message;
}
