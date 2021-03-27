package webbanhang.repository.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import webbanhang.dto.OrderDtos;
import webbanhang.dto.searchDto.CategorySearchDto;
import webbanhang.dto.searchDto.OrderSearchDto;
import webbanhang.entity.OrderEntity;
import webbanhang.entity.ProductEntity;
import webbanhang.mapper.OrderMapper;
import webbanhang.repository.custom.OrderRepositoryCustom;
import webbanhang.utils.DateUtils;

@Repository
public class OrderRepositoryImpl implements OrderRepositoryCustom{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<OrderDtos> findBySearch(OrderSearchDto dto) {
		int pageIndex = dto.getPageIndex()-1;
		int pageSize = dto.getPageSize();
		StringBuilder sql = new StringBuilder("SELECT *FROM tblorder WHERE 1=1 ");
		StringBuilder sqlCount= new StringBuilder("select count(id) FROM tblorder WHERE 1=1");
		if(StringUtils.isNotEmpty(dto.getKeyword()) && StringUtils.isNotBlank(dto.getKeyword())) {
			sql.append(" AND code LIKE '%"+dto.getKeyword()+"%'");
			sql.append(" OR customer_address LIKE '%"+dto.getKeyword()+"%'");
			sql.append(" OR customer_name LIKE '%"+dto.getKeyword()+"%'");
			sql.append(" OR customer_phone LIKE '%"+dto.getKeyword()+"%'");
			sql.append(" OR customer_email LIKE '%"+dto.getKeyword()+"%'");
			sqlCount.append(" AND code LIKE '%"+dto.getKeyword()+"%'");
			sqlCount.append(" OR customer_address LIKE '%"+dto.getKeyword()+"%'");
			sqlCount.append(" OR customer_name LIKE '%"+dto.getKeyword()+"%'");
			sqlCount.append(" OR customer_phone LIKE '%"+dto.getKeyword()+"%'");
			sqlCount.append(" OR customer_email LIKE '%"+dto.getKeyword()+"%'");
		}		
		
		if (dto.getStatus() != null) {
			if (dto.getStatus() != 0) {
				sql.append(" AND status = "+dto.getStatus());
				sqlCount.append(" AND status = "+dto.getStatus());
			}			
		}
		
		if (StringUtils.isNotBlank(dto.getDateOrder())) {
			sql.append(" AND createddate LIKE '%"+DateUtils.convertStringToDate(dto.getDateOrder())+"%' ");
			sqlCount.append(" AND createddate LIKE '%"+DateUtils.convertStringToDate(dto.getDateOrder())+"%' ");
		}
		
		if (StringUtils.isNotBlank(dto.getDateRecive())) {
			sql.append(" AND delivery_date LIKE '%"+DateUtils.convertStringToDate(dto.getDateRecive())+"%' ");
			sqlCount.append(" AND delivery_date LIKE '%"+DateUtils.convertStringToDate(dto.getDateRecive())+"%' ");
		}
		
		
		
		
		Query query = em.createNativeQuery(sql.toString(),OrderEntity.class);
		Query queryCount = em.createNativeQuery(sqlCount.toString());
		
		int startPosition = pageIndex* pageSize;
		query.setFirstResult(startPosition);
		query.setMaxResults(dto.getPageSize());
		
		List<OrderEntity> orderEntities = query.getResultList();
		List<OrderDtos> listOderDto = orderEntities.stream().map(item->OrderMapper.convertToDto(item)).collect(Collectors.toList());
		BigInteger count =   (BigInteger) queryCount.getSingleResult();
		long total = count.longValue();
		Pageable pageable = new PageRequest(pageIndex,pageSize);
		Page<OrderDtos> page3 = new PageImpl<OrderDtos>(listOderDto,pageable,total);
		return page3;
	}
	
}
