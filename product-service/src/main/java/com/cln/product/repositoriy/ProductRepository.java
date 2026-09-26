package com.cln.product.repositoriy;

import com.cln.product.enity.ProductEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
  Optional<ProductEntity> findBySku(String sku);

}
