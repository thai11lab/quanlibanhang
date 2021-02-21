package webbanhang.controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class CartController {
	
	@GetMapping("/detail_cart")
	public ModelAndView getProductInCart() {
		ModelAndView modelAndView = new ModelAndView("/web/cart");
		return modelAndView;
	}
	
	
	
}
