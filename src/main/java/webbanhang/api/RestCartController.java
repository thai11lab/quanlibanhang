package webbanhang.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import webbanhang.dto.CartDto;
import webbanhang.dto.ProductDto;
import webbanhang.service.CartService;
import webbanhang.service.ProductService;

@RestController(value = "apiCart")
@RequestMapping("/api/cart")
public class RestCartController {
	
	@Autowired
	ProductService productService;
	
	@Autowired 
	CartService cartService;
	
	
	@RequestMapping(value = "/{productId}",method = RequestMethod.GET)	
	public ResponseEntity<Map<Long, CartDto>> getOne(@PathVariable("productId") Long productId,HttpServletRequest request){
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<Long,CartDto> cartItem = (Map<Long, CartDto>) session.getAttribute("myCart"); 
		if (cartItem == null) {
			cartItem = new HashMap<Long, CartDto>();
			session.setAttribute("myCartNum", cartItem.size());
		}
			
		ProductDto productDto = productService.getOne(productId);
		if (productDto != null) {
			if (cartItem.containsKey(productId)) {
				CartDto cartDto = cartItem.get(productId);
				cartDto.setQuantity(cartDto.getQuantity()+1);
				cartDto.setProductDto(productDto);
				cartDto.setTotalPrice(productDto.getPrice()*cartDto.getQuantity());
				cartItem.put(productId, cartDto);
			}else {
				CartDto cartDto = new CartDto();
				cartDto.setProductDto(productDto);
				cartDto.setQuantity(1);
				cartDto.setTotalPrice(productDto.getPrice()*cartDto.getQuantity());
				cartItem.put(productId, cartDto);
			}
			
		}
		session.setAttribute("myCartNum", cartItem.size());
		session.setAttribute("myCart",cartItem);
		return new ResponseEntity<Map<Long, CartDto>>(cartItem,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "remove/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Map<Long, CartDto>> removeCart(@PathVariable("productId") Long productId,HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<Long,CartDto> cartItem = (Map<Long, CartDto>) session.getAttribute("myCart"); 
		if (cartItem == null) {
			cartItem = new HashMap<Long, CartDto>();
			session.setAttribute("myCartNum", 0);
		}
		if (cartItem.containsKey(productId)) {
			cartItem.remove(productId);
		}			
		session.setAttribute("myCart", cartItem);
		session.setAttribute("myCartNum", cartItem.size());
		return new ResponseEntity<Map<Long, CartDto>>(cartItem,HttpStatus.OK);
	}
}
