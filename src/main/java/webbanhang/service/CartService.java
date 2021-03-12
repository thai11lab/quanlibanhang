package webbanhang.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import webbanhang.dto.CartDto;
import webbanhang.dto.ProductDto;

@Service
public interface CartService {

	List<CartDto> addCartToSession(ProductDto productDto);
	
}
