package webbanhang.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webbanhang.dto.CartDto;
import webbanhang.dto.searchDto.ProductSearchDto;

@Controller
@RequestMapping("/home")
public class CheckOutController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/checkout",method = RequestMethod.GET)	
	public ModelAndView getViewCheckOut(@ModelAttribute("model") ProductSearchDto dto,HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("web/checkout");
		Map<Long, CartDto> listCart=  (Map<Long, CartDto>) httpSession.getAttribute("myCart");
		List<CartDto> listProductOrder = new ArrayList<CartDto>();
		if (listCart != null) {
			for (Map.Entry<Long,CartDto> item : listCart.entrySet()) {
				listProductOrder.add(item.getValue());
			}
		}	
		double totalMoney = CartController.getTotalMoney(listProductOrder);
		modelAndView.addObject("listProductOrder", listProductOrder);
		modelAndView.addObject("totalMoney",totalMoney);
		return modelAndView;
		
	}
	
	
}
