package com.cln.product.dto.req;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ali Mohammadi
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductReq {

  private Long id;
  private String name;
  private String description;
  private String sku;
  private BigDecimal price;
  private Integer stockQuantity;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
