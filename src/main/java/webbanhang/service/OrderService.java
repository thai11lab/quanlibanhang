package webbanhang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import webbanhang.dto.CartDto;
import webbanhang.dto.OrderDtos;

@Service
public interface OrderService {

	OrderDtos save(OrderDtos dto,List<CartDto> listProductOrder);
	
}
