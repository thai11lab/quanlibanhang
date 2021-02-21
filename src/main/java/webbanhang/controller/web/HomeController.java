package webbanhang.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductEntity;
import webbanhang.service.ProductService;

@Controller(value = "HomeWebController")
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public ModelAndView home() {
	
		ModelAndView modelAndView = new ModelAndView("web/home");
		List<ProductEntity> productEntities = productService.findByDateMin();
		modelAndView.addObject("listProductNew", productEntities);
		return modelAndView;
	}
}
