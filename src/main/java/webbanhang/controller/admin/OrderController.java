package webbanhang.controller.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webbanhang.dto.searchDto.ProductSearchDto;
import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductEntity;

@Controller
@RequestMapping("/admin")
public class OrderController {
	
	@RequestMapping(value = "/order",method = RequestMethod.GET)	
	public ModelAndView listProductBySearch(@ModelAttribute("model") ProductSearchDto dto) {
		ModelAndView modelAndView = new ModelAndView("/admin/order/order");
		
		
		return modelAndView;
		
	}
}
