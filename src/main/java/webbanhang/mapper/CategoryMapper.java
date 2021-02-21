package webbanhang.mapper;

import webbanhang.dto.CategoryDto;
import webbanhang.dto.ProductDto;
import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductEntity;

public class CategoryMapper {
	public static CategoryDto convertToDto(CategoryEntity entity) {
		CategoryDto dto = new CategoryDto();
		dto.setCode(entity.getCode());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setName(entity.getName());
		return dto;
	}
	
	public static CategoryEntity convertToEntity(CategoryDto dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setCode(dto.getCode());
		entity.setCreatedBy(dto.getCreatedBy());
		entity.setCreatedDate(dto.getCreatedDate());
		
		entity.setModifiedBy(dto.getModifiedBy());
		entity.setModifiedDate(dto.getModifiedDate());
		entity.setName(dto.getName());
		
		return entity;
		
	}
}
