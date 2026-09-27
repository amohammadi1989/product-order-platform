package com.cln.product.enity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author Ali Mohammadi
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreated() {
    var localDate = LocalDateTime.now();
    createdAt = localDate;
    updatedAt = localDate;
  }

  @PreUpdate
  protected void onUpdated() {
    var localDateTime = LocalDateTime.now();
    updatedAt = localDateTime;
    if(createdAt==null)
      createdAt=localDateTime;
  }
}
