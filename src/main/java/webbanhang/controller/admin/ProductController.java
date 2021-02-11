package webbanhang.controller.admin;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import webbanhang.dto.searchDto.ProductSearchDto;
import webbanhang.dto.searchDto.searchDto;
import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductEntity;
import webbanhang.repository.CategoryRepository;
import webbanhang.repository.ProductRepository;
import webbanhang.service.ProductService;

@Controller(value = "ProductController")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	private ProductRepository productRepository; 
	
	@Autowired
	private CategoryRepository categoryRepository;
	
//	@RequestMapping(value = "/admin/product",method = RequestMethod.GET)
//	public ModelAndView listProduct(@RequestParam(name = "pageIndex",defaultValue = "1") int pageIndex,@RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
//		ModelAndView modelAndView = new ModelAndView("admin/product/listProduct");		
//		
//		Page<ProductEntity> pageData =  productRepository.findAll(new PageRequest(pageIndex-1, pageSize));
//		List<ProductEntity> lisProductEntities = pageData.getContent();
//		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
//		Long totalProduct = pageData.getTotalElements();
//		int totalPage = pageData.getTotalPages();
//		modelAndView.addObject("listCategory",categoryEntities);
//		modelAndView.addObject("pageIndex",pageIndex);
//		modelAndView.addObject("pageSize",pageSize);
//		modelAndView.addObject("totalPage", totalPage);
//		modelAndView.addObject("listProduct", lisProductEntities);
//		
//		modelAndView.addObject("totalProduct", totalProduct);
//		
//		return modelAndView;
//		
//	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/admin/product",method = RequestMethod.GET)	
	public ModelAndView listProductBySearch(@ModelAttribute("model") ProductSearchDto dto) {
		ModelAndView modelAndView = new ModelAndView("admin/product/listProduct");
		if (dto.getPageIndex() == 0 && dto.getPageSize()==0) {
			dto.setPageIndex(1);
			dto.setPageSize(10);
		}
		Page<ProductEntity> pageData = productRepository.findBySearch(dto);
		
		List<ProductEntity> lisProductEntities = pageData.getContent();
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		Long totalProduct = pageData.getTotalElements();
		int totalPage = pageData.getTotalPages();
		modelAndView.addObject("listCategory",categoryEntities);
		modelAndView.addObject("pageIndex",dto.getPageIndex());
		modelAndView.addObject("pageSize",dto.getPageSize());
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("listProduct", lisProductEntities);
		
		modelAndView.addObject("totalProduct", totalProduct);
		
		return modelAndView;
		
	}
	
	
	
//	@PostMapping(path = "/api/product")
//	public ProductDto addProduct(@RequestBody ProductDto dto){
//		ProductDto result = productService.saveOne(dto,null);
//		return result;
//	}
//	@RequestMapping(value = "/api/addproduct",method = RequestMethod.POST)
//	public ResponseEntity<ProductDto> addAndUpdate(@RequestBody ProductDto dto){
//		ProductDto result = productService.saveOne(dto,null);
//		return new ResponseEntity<ProductDto>(dto, dto != null ? HttpStatus.OK :HttpStatus.BAD_REQUEST);
//	}
	
}
