package webbanhang.mapper;

import org.modelmapper.ModelMapper;

import webbanhang.dto.OrderDtos;
import webbanhang.entity.OrderEntity;

public class OrderMapper {
	
	public static OrderDtos convertToDto(OrderEntity entity) {
		ModelMapper mapper = new ModelMapper();
		
		OrderDtos dtos= mapper.map(entity,OrderDtos.class);
		
		return dtos;
	}
	
	public static OrderEntity convertToEntity(OrderDtos dtos) {
		ModelMapper mapper = new ModelMapper();
		
		OrderEntity entity = mapper.map(dtos,OrderEntity.class);
		
		return entity;
	}
}
