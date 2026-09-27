package com.cln.product.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Ali Mohammadi
 */
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResDto {
  private String msg;
  private Integer code;

}
