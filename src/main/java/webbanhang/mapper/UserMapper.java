package webbanhang.mapper;

import org.modelmapper.ModelMapper;

import webbanhang.dto.OrderDtos;
import webbanhang.dto.UserDto;
import webbanhang.entity.OrderEntity;
import webbanhang.entity.UserEntity;

public class UserMapper {
	public static UserDto convertToDto(UserEntity entity) {
		ModelMapper mapper = new ModelMapper();
		
		UserDto dtos= mapper.map(entity,UserDto.class);
		
		return dtos;
	}
	
	public static UserEntity convertToEntity(UserDto dtos) {
		ModelMapper mapper = new ModelMapper();
		UserEntity entity = mapper.map(dtos,UserEntity.class);
		return entity;
	}
}
