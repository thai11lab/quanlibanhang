package webbanhang.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import webbanhang.dto.CartDto;
import webbanhang.dto.OrderDtos;
import webbanhang.service.OrderService;

@RestController
@RequestMapping("/api/checkout")
public class RestCheckoutController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "",method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody OrderDtos dtos,HttpSession httpSession){
		Map<Long, CartDto> listCart=  (Map<Long, CartDto>) httpSession.getAttribute("myCart");
		List<CartDto> listProductOrder = new ArrayList<CartDto>();
		if (listCart != null) {
			for (Map.Entry<Long,CartDto> item : listCart.entrySet()) {
				listProductOrder.add(item.getValue());
			}
		}	
		
		Object result = orderService.save(dtos,listProductOrder);
		httpSession.removeAttribute("myCart");
		httpSession.setAttribute("myCartNum", 0);
		return new ResponseEntity<Object>(result,HttpStatus.OK);
	}
}
