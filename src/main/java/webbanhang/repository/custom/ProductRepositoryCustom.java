package webbanhang.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import webbanhang.dto.searchDto.searchDto;
import webbanhang.entity.ProductEntity;

public interface ProductRepositoryCustom {
	Page<ProductEntity> findBySearch(searchDto dto);
}
