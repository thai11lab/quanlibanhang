package webbanhang.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import webbanhang.dto.CartDto;
import webbanhang.dto.OrderDtos;
import webbanhang.dto.searchDto.CategorySearchDto;
import webbanhang.dto.searchDto.OrderSearchDto;

@Service
public interface OrderService {

	OrderDtos save(OrderDtos dto,List<CartDto> listProductOrder);

	List<OrderDtos> findAll();

	Page<OrderDtos> findBySearch(OrderSearchDto dto);
	
}
