package webbanhang.repository.custom;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import webbanhang.dto.ProductDto;
import webbanhang.dto.searchDto.searchDto;
import webbanhang.entity.ProductEntity;

public interface ProductRepositoryCustom {
	Page<ProductEntity> findBySearch(searchDto dto);
	List<ProductEntity> findByDateMin();
	List<ProductDto> getProductAsCategory(ProductDto productDto);
}
