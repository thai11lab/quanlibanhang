package webbanhang.repository.custom;

import org.springframework.data.domain.Page;

import webbanhang.dto.searchDto.CategorySearchDto;
import webbanhang.entity.CategoryEntity;

public interface CategoryRepositoryCustom {
	Page<CategoryEntity> findBySearch(CategorySearchDto dto);
}
