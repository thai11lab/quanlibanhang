package webbanhang.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webbanhang.dto.OrderDtos;
import webbanhang.dto.searchDto.ProductSearchDto;
import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductEntity;
import webbanhang.service.OrderService;

@Controller
@RequestMapping("/admin")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@RequestMapping(value = "/order",method = RequestMethod.GET)	
	public ModelAndView listProductBySearch(@ModelAttribute("model") ProductSearchDto dto) {
		ModelAndView modelAndView = new ModelAndView("/admin/order/order");
		List<OrderDtos>  listOrder= orderService.findAll();
		modelAndView.addObject("listOrder", listOrder);
		return modelAndView;
		
	}
}
