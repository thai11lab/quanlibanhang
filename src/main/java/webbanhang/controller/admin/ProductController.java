package webbanhang.controller.admin;

import java.awt.print.Pageable;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import webbanhang.dto.ProductDto;
import webbanhang.entity.ProductEntity;
import webbanhang.repository.ProductRepository;
import webbanhang.service.ProductService;

@Controller(value = "ProductController")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	private ProductRepository productRepository; 
	
	@RequestMapping(value = "/admin/product",method = RequestMethod.GET)
	public ModelAndView listProduct(@RequestParam(name = "pageIndex",defaultValue = "10") int pageIndex,@RequestParam(value = "pageSize",defaultValue = "1") int pageSize) {
		ModelAndView modelAndView = new ModelAndView("admin/product/listProduct");		
		
		Page<ProductEntity> pageData =  productRepository.findAll(new PageRequest(pageIndex-1, pageSize));
		List<ProductEntity> lisProductEntities = pageData.getContent();
		Long totalProduct = pageData.getTotalElements();
		int totalPage = pageData.getTotalPages();
		modelAndView.addObject("pageIndex",pageIndex);
		modelAndView.addObject("pageSize",pageSize);
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
