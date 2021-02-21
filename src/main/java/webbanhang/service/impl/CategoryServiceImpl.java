package webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanhang.dto.CategoryDto;
import webbanhang.dto.ProductDto;
import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductEntity;
import webbanhang.mapper.CategoryMapper;
import webbanhang.repository.CategoryRepository;
import webbanhang.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public CategoryDto saveOne(CategoryDto dto, Long id) {
		
		CategoryEntity categoryEntity = CategoryMapper.convertToEntity(dto);
		
		if(id != null) {			
			CategoryEntity categoryEdit = categoryRepository.getOne(id);
			categoryEdit.setCode(categoryEntity.getCode());		
			categoryEdit.setName(categoryEntity.getName());
			
			categoryRepository.save(categoryEdit);
			
	
			
			return new CategoryDto(categoryEdit);
		}
		categoryRepository.save(categoryEntity);	
		return new CategoryDto(categoryEntity);
	}

	@Override
	public CategoryDto getOne(Long id) {
		CategoryEntity entity = categoryRepository.getOne(id);		
		return new CategoryDto(entity);
	}

	@Override
	public void deleteOne(Long id) {
		// TODO Auto-generated method stub
		categoryRepository.delete(id);
	}

}
