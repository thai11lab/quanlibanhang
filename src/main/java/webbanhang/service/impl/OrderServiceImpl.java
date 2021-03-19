package webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanhang.dto.OrderDtos;
import webbanhang.repository.OrderRepository;
import webbanhang.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public void save(OrderDtos dto) {
		// TODO Auto-generated method stub
//		orderRepository.save(dto);
	}

}
