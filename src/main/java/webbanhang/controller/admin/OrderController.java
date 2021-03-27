package webbanhang.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webbanhang.dto.OrderDtos;
import webbanhang.dto.searchDto.CategorySearchDto;
import webbanhang.dto.searchDto.OrderSearchDto;
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
	public ModelAndView listProductBySearch(@ModelAttribute("model") OrderSearchDto dto,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/admin/order/order");
		if (dto.getPageIndex() == 0 && dto.getPageSize()==0) {
			dto.setPageIndex(1);
			dto.setPageSize(10);
		}
		
		Page<OrderDtos> pageData = orderService.findBySearch(dto);
		List<OrderDtos> listOder = pageData.getContent();
		
		Long totalProduct = pageData.getTotalElements();
		int totalPage = pageData.getTotalPages();
		
		modelAndView.addObject("pageIndex",dto.getPageIndex());
		modelAndView.addObject("pageSize",dto.getPageSize());
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("listOrder", listOder);
		
//		modelAndView.addObject("totalProduct", totalProduct);
		return modelAndView;
		
	}
}
