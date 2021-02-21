package webbanhang.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webbanhang.dto.ProductDto;
import webbanhang.service.ProductService;

@Controller
public class ProductDetailController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/home/detail_product/{id}",method = RequestMethod.GET)	
	public ModelAndView productDetail(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("/web/product/detail_product");
		ProductDto productDto = productService.getOne(id);
		List<ProductDto> listProductCatgoryAs = productService.getProductAsCategory(productDto);
		modelAndView.addObject("product", productDto);
		modelAndView.addObject("listProductAsCategory", listProductCatgoryAs);
		return modelAndView;
		
	}
}
