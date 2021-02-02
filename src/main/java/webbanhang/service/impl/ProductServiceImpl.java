package webbanhang.service.impl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webbanhang.dto.ProductDto;
import webbanhang.entity.ProductEntity;
import webbanhang.mapper.ProductMapper;
import webbanhang.repository.ProductRepository;
import webbanhang.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
//	@Autowired
//	ProductMapper productMapper; 
	
	
	@Override
	@Transactional
	public ProductDto saveOne(ProductDto dto,Long id) {	
		ProductMapper productMapper = new ProductMapper(); 
		ProductEntity entity = productMapper.convertToEntity(dto);
		if(id != null) {
			ProductEntity productEdit = productRepository.getOne(id);
			productEdit.setCode(entity.getCode());
			productEdit.setDescription(entity.getDescription());
			productEdit.setIsShow(entity.getIsShow());
			if(entity.getMainImageUrl() != null) {
				productEdit.setMainImageUrl(entity.getMainImageUrl());
			}		
			productEdit.setName(entity.getName());
			productEdit.setPrice(entity.getPrice());
			productEdit.setWebsiteUrl(entity.getWebsiteUrl());
			productEdit = productRepository.save(productEdit);
			return new ProductDto(productEdit);
		}
		productRepository.save(entity);
		return new ProductDto(entity);
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
	
}
