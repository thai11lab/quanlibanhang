package webbanhang.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "HomeWebController")
public class HomeController {
	
	@RequestMapping(value = "/home")
	public ModelAndView home() {
		return new ModelAndView("");
	}
}
