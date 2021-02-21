package webbanhang.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webbanhang.dto.searchDto.CategorySearchDto;
import webbanhang.dto.searchDto.ProductSearchDto;
import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductEntity;
import webbanhang.repository.CategoryRepository;

@Controller(value = "CategoryController")
public class CategoryController {
	
	
	@Autowired
	CategoryRepository categoryRepository; 
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/admin/category",method = RequestMethod.GET)	
	public ModelAndView listProductBySearch(@ModelAttribute("model") CategorySearchDto dto) {
		ModelAndView modelAndView = new ModelAndView("admin/category/listCategory");
		if (dto.getPageIndex() == 0 && dto.getPageSize()==0) {
			dto.setPageIndex(1);
			dto.setPageSize(10);
		}
		Page<CategoryEntity> pageData = categoryRepository.findBySearch(dto);
		
		List<CategoryEntity> listCategoryEntities = pageData.getContent();
		
		Long totalProduct = pageData.getTotalElements();
		int totalPage = pageData.getTotalPages();
		modelAndView.addObject("pageIndex",dto.getPageIndex());
		modelAndView.addObject("pageSize",dto.getPageSize());
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("listCategory", listCategoryEntities);
		
		modelAndView.addObject("totalProduct", totalProduct);
		
		return modelAndView;
		
	}
}
