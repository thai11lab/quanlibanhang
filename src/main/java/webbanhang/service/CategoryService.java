package webbanhang.service;

import org.springframework.stereotype.Service;

import webbanhang.dto.CategoryDto;

@Service
public interface CategoryService {

	CategoryDto saveOne(CategoryDto dto, Long id);

	CategoryDto getOne(Long id);

	void deleteOne(Long id);
	
}
