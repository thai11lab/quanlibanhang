package webbanhang.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
		dto.setStatus(0);
		dto.setCode("DH"+UUID.randomUUID().toString().substring(0,5));
		dto.setDeliveryDate(new Date());
		double totaMoney =0;
		if (cartDtos.size()>0) {
			for (CartDto cartDto : cartDtos) {
				totaMoney+=cartDto.getTotalPrice();
			}
		}
		dto.setTotalMoney(totaMoney);
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
	@Override
	public List<OrderDtos> findAll() {
		// TODO Auto-generated method stub
		List<OrderEntity> ordeEntities = orderRepository.findAll(); 
		return ordeEntities.stream().map(item->OrderMapper.convertToDto(item)).collect(Collectors.toList());
	}

}
