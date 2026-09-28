package com.cln.product.repositoriy;

import com.cln.product.enity.CategoryEntity;
import com.cln.product.enity.ProductEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

}
