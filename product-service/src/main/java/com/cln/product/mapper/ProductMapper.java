package com.cln.product.mapper;

import com.cln.product.dto.req.ProductReq;
import com.cln.product.dto.res.ProductRes;
import com.cln.product.enity.ProductEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * @author Ali Mohammadi
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductRes toDto(ProductEntity entity);
  ProductEntity toEntity(ProductReq req);
  List<ProductRes> toDtos(List<ProductEntity> entities);
  List<ProductEntity> toEntities(List<ProductReq> reqs);
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "category", ignore = true)
  void updateEntity(ProductReq request, @MappingTarget ProductEntity entity);
}
