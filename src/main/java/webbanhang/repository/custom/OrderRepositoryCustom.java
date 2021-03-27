package webbanhang.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import webbanhang.dto.OrderDtos;
import webbanhang.dto.searchDto.CategorySearchDto;
import webbanhang.dto.searchDto.OrderSearchDto;

@Repository
public interface OrderRepositoryCustom {
	Page<OrderDtos> findBySearch(OrderSearchDto dto);
}
