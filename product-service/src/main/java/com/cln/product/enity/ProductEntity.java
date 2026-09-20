package com.cln.product.enity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ali Mohammadi
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT", uniqueConstraints = {
    @UniqueConstraint(name = "uk_product_sku", columnNames = "sku")})
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(length = 1000)
  private String description;
  @Column(nullable = false, length = 50, unique = true)
  private String sku;
  @Column(nullable = false, precision = 19, scale = 2)
  private BigDecimal price;
  @Column(nullable = false)
  private Integer stockQuantity;
  private Boolean active = true;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreated() {
    LocalDateTime localDate = LocalDateTime.now();
    createdAt = localDate;
    updatedAt = localDate;
    if (stockQuantity == null) {
      stockQuantity = 0;
    }
    if (active == null) {
      active = true;
    }
  }

  @PreUpdate
  protected void onUpdated() {
    LocalDateTime localDateTime = LocalDateTime.now();
    updatedAt = localDateTime;
  }
}
