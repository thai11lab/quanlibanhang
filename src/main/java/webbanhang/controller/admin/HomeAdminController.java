package webbanhang.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "HomeAdminController")
public class HomeAdminController {
	
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView("admin/home");
		return modelAndView;
	}
	
	//Trong thằng security thì thằng login-page trong phai trung với đường dẫn này login-page="/login"
		@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
		public ModelAndView loginPage() {
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
}
