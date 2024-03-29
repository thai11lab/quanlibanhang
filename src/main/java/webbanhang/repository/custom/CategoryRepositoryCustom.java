package webbanhang.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import webbanhang.dto.searchDto.CategorySearchDto;
import webbanhang.entity.CategoryEntity;
@Repository
public interface CategoryRepositoryCustom {
	Page<CategoryEntity> findBySearch(CategorySearchDto dto);
}
