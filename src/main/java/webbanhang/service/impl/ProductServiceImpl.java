package webbanhang.service.impl;


import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import webbanhang.dto.ProductDto;
import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductCategory;
import webbanhang.entity.ProductEntity;
import webbanhang.mapper.ProductMapper;
import webbanhang.repository.CategoryRepository;
import webbanhang.repository.ProductCategoryRepository;
import webbanhang.repository.ProductRepository;
import webbanhang.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
//	@Autowired
//	ProductMapper productMapper; 
	@Autowired
	ProductCategoryRepository productCategoryRepository; 
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@Override
	@Transactional
	public ProductDto saveOne(ProductDto dto,Long id) {	
		ProductMapper productMapper = new ProductMapper(); 
		ProductEntity productEntity = productMapper.convertToEntity(dto);
		
		if(id != null) {			
			ProductEntity productEdit = productRepository.getOne(id);
			productEdit.setCode(productEntity.getCode());
			productEdit.setDescription(productEntity.getDescription());
			productEdit.setIsShow(productEntity.getIsShow());
			if(productEntity.getMainImageUrl() != null) {
				productEdit.setMainImageUrl(productEntity.getMainImageUrl());
			}		
			productEdit.setName(productEntity.getName());
			productEdit.setPrice(productEntity.getPrice());
			productEdit.setWebsiteUrl(productEntity.getWebsiteUrl());
//			productEdit.setProductCategorie(productEntity.getProductCategorie());
			productRepository.save(productEdit);
			
			List<Long> listOldCategoryId = productCategoryRepository.getCategoryFromProductId(id);
			for (Long oldCategoryId : listOldCategoryId) {
				productCategoryRepository.delete(oldCategoryId);
			}
			for (Long categoryId : dto.getIdCategories()) {
				CategoryEntity categoryEntity = categoryRepository.findOne(categoryId);
				ProductCategory productCategory = new ProductCategory();
				productCategory.setCategoryEntity(categoryEntity);
				productCategory.setProductEntity(productEdit);
				productCategoryRepository.saveAndFlush(productCategory);
			}
			
			return new ProductDto(productEdit);
		}
		productRepository.save(productEntity);
		for (Long categoryId : dto.getIdCategories()) {
			CategoryEntity categoryEntity = categoryRepository.findOne(categoryId);
			ProductCategory productCategory = new ProductCategory();
			productCategory.setCategoryEntity(categoryEntity);
			productCategory.setProductEntity(productEntity);
			productCategoryRepository.save(productCategory);
		}
		
		return new ProductDto(productEntity);
	}


	@Override
	public ProductDto getOne(Long id) {
		ProductEntity entity = productRepository.getOne(id);		
		return new ProductDto(entity);
	}


	@Override
	public void deleteOne(Long id) {
		productRepository.delete(id);
	}


	@Override
	public ProductDto updateImage(String mainImageUrl, Long id) {
		ProductEntity entity = productRepository.getOne(id);
		entity.setMainImageUrl(mainImageUrl);
		entity = productRepository.save(entity);
		return new ProductDto(entity);
	}



	
}
