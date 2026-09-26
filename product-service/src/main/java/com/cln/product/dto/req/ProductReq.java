package com.cln.product.dto.req;

import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Ali Mohammadi
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductReq {
  private Long id;
  @NotBlank(message = "name is required")
  private String name;
  private String description;
  @NotBlank(message = "sku is required")
  @Size(max = 50, message = "sku must not exceed 50 characters")
  private String sku;
  @NotNull(message = "price is required")
  @DecimalMin(value = "1.0", message = "price must be greater than or equal to 1")
  @DecimalMax(value = "9999.0", message = "price must be less than or equal to 9999")
  private BigDecimal price;
  @NotNull(message = "stock quantity is required")
  @Min(value = 1, message = "stock quantity must be between 1 and 100")
  @Max(value = 100, message = "stock quantity must be between 1 and 100")
  private Integer stockQuantity;
  @NotNull(message = "active is required")
  private Boolean active;
}
