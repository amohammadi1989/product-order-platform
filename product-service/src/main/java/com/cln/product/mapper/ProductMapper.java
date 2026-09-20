package com.cln.product.mapper;

import com.cln.product.dto.req.ProductReq;
import com.cln.product.dto.res.ProductRes;
import com.cln.product.enity.ProductEntity;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @author Ali Mohammadi
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductRes toDto(ProductEntity entity);
  ProductEntity toEntity(ProductReq req);
  List<ProductRes> toDtos(List<ProductEntity> entities);
  List<ProductEntity> toEntities(List<ProductReq> reqs);
}
