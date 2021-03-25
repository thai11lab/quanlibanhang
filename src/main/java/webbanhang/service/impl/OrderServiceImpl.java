package webbanhang.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanhang.dto.CartDto;
import webbanhang.dto.OrderDtos;
import webbanhang.entity.OrderEntity;
import webbanhang.entity.OrderProductEntity;
import webbanhang.entity.ProductEntity;
import webbanhang.mapper.OrderMapper;
import webbanhang.mapper.ProductMapper;
import webbanhang.repository.OrderProductRepository;
import webbanhang.repository.OrderRepository;
import webbanhang.repository.ProductRepository;
import webbanhang.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderProductRepository orderProductRepository;
	
	@Autowired
	ProductRepository productRepository;
	@Override
	public OrderDtos save(OrderDtos dto,List<CartDto> cartDtos) {
		ProductMapper productMapper = new ProductMapper();
		OrderEntity entity = OrderMapper.convertToEntity(dto);
		orderRepository.save(entity);
		if (cartDtos.size()>0 && cartDtos != null) {					
			for (CartDto cartDto : cartDtos) {
				ProductEntity productEntity = productRepository.findOne(cartDto.getProductDto().getId());
				OrderProductEntity orderProductEntity = new OrderProductEntity();
				orderProductEntity.setProductEntity(productEntity);
				orderProductEntity.setOrderEntity(entity);				
				orderProductRepository.save(orderProductEntity);
			}
		}
		return dto;
	}

}
