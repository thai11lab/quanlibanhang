package webbanhang.service;

import org.springframework.stereotype.Service;

import webbanhang.dto.OrderDtos;

@Service
public interface OrderService {

	void save(OrderDtos dto);
	
}
