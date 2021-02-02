package webbanhang.mapper;

import webbanhang.dto.ProductDto;
import webbanhang.entity.ProductEntity;

public class ProductMapper {
	
	public ProductDto convertToDto(ProductEntity entity) {
		ProductDto dto = new ProductDto();
		dto.setCode(entity.getCode());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setDescription(entity.getDescription());
		dto.setIsShow(entity.getIsShow());
		dto.setMainImageUrl(entity.getMainImageUrl());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setWebsiteUrl(entity.getWebsiteUrl());
		return dto;
	}
	
	public ProductEntity convertToEntity(ProductDto dto) {
		ProductEntity entity = new ProductEntity();
		entity.setCode(dto.getCode());
		entity.setCreatedBy(dto.getCreatedBy());
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setDescription(dto.getDescription());
		entity.setIsShow(dto.getIsShow());
		entity.setMainImageUrl(dto.getMainImageUrl());
		entity.setModifiedBy(dto.getModifiedBy());
		entity.setModifiedDate(dto.getModifiedDate());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setWebsiteUrl(dto.getWebsiteUrl());
		return entity;
		
	}
}
