package webbanhang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import webbanhang.dto.ProductDto;
import webbanhang.entity.ProductEntity;

@Service
public interface ProductService {

	ProductDto saveOne(ProductDto dto,Long id);

	ProductDto getOne(Long id);

	void deleteOne(Long id);
	
	ProductDto updateImage(String mainImageUrl, Long id);

	List<ProductEntity> findByDateMin();

	List<ProductDto> getProductAsCategory(ProductDto productDto);
}
