package webbanhang.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webbanhang.dto.CartDto;

@Controller
public class CartController {
	
	@SuppressWarnings("unchecked")
	@GetMapping("/detail_cart")
	public ModelAndView getProductInCart(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/web/cart");
		Map<Long, CartDto> listCart =  (Map<Long, CartDto>) session.getAttribute("myCart");
		
		List<CartDto> listProductInCart = new ArrayList<CartDto>();
		if (listCart != null) {
			for (Map.Entry<Long,CartDto> item : listCart.entrySet()) {
				listProductInCart.add(item.getValue());
			}
		}	
		modelAndView.addObject("listProductInCart", listProductInCart);
		modelAndView.addObject("totalMoney",getTotalMoney(listProductInCart));
		return modelAndView;
	}
	
	
	public static double getTotalMoney(List<CartDto> cartDto) {
		double totalMoney=0;
		for (CartDto itemCart : cartDto) {
			totalMoney += itemCart.getTotalPrice();
		}
		return totalMoney;
	}
	
	
}
