package webbanhang.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import webbanhang.dto.searchDto.CategorySearchDto;
import webbanhang.dto.searchDto.searchDto;
import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductEntity;
import webbanhang.repository.CategoryRepository;
import webbanhang.repository.custom.CategoryRepositoryCustom;

public class CategoryRepositoryImpl implements CategoryRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Page<CategoryEntity> findBySearch(CategorySearchDto dto) {
		int pageIndex = dto.getPageIndex()-1;
		int pageSize = dto.getPageSize();
		StringBuilder sql = new StringBuilder("SELECT *FROM categorys WHERE 1=1 ");
		StringBuilder sqlCount= new StringBuilder("select count(id) FROM categorys WHERE 1=1");
		if(StringUtils.isNotEmpty(dto.getKeyword()) && StringUtils.isNotBlank(dto.getKeyword())) {
			sql.append(" AND name LIKE '%"+dto.getKeyword()+"%'");
			sql.append(" OR code LIKE '%"+dto.getKeyword()+"%'");
			
			sqlCount.append(" AND name LIKE '%"+dto.getKeyword()+"%'");
			sqlCount.append(" OR code LIKE '%"+dto.getKeyword()+"%'");
		}		
		
		
		
		Query query = em.createNativeQuery(sql.toString(),CategoryEntity.class);
		Query queryCount = em.createNativeQuery(sqlCount.toString());
		
		int startPosition = pageIndex* pageSize;
		query.setFirstResult(startPosition);
		query.setMaxResults(dto.getPageSize());
		
		List<CategoryEntity> productEntities = query.getResultList();
		BigInteger count =   (BigInteger) queryCount.getSingleResult();
		long total = count.longValue();
		Pageable pageable = new PageRequest(pageIndex,pageSize);
		Page<CategoryEntity> page3 = new PageImpl<CategoryEntity>(productEntities,pageable,total);
		return page3;
	}
	
}
