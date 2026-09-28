package com.cln.product.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ali Mohammadi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResDto {
  private Long id;
  private String name;
  private String description;
  private String code;
  private Boolean active;
}
