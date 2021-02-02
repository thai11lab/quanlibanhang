package webbanhang.service;

import org.springframework.stereotype.Service;

import webbanhang.dto.ProductDto;

@Service
public interface ProductService {

	ProductDto saveOne(ProductDto dto,Long id);

	ProductDto getOne(Long id);

	void deleteOne(Long id);
	
}
