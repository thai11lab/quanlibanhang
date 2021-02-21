package webbanhang.repository.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import webbanhang.dto.CategoryDto;
import webbanhang.dto.ProductDto;
import webbanhang.dto.searchDto.searchDto;
import webbanhang.entity.CategoryEntity;
import webbanhang.entity.ProductEntity;
import webbanhang.repository.CategoryRepository;
import webbanhang.repository.custom.ProductRepositoryCustom;

public class ProductRepositoryImpl implements ProductRepositoryCustom{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	CategoryRepository categoryRepository; 
	
	@SuppressWarnings("unchecked")
	@Override
	public Page<ProductEntity> findBySearch(searchDto dto) {
		int pageIndex = dto.getPageIndex()-1;
		int pageSize = dto.getPageSize();
		StringBuilder sql = new StringBuilder("SELECT *FROM product WHERE 1=1 ");
		StringBuilder sqlCount= new StringBuilder("select count(id) FROM product WHERE 1=1");
		if(StringUtils.isNotEmpty(dto.getKeyword()) && StringUtils.isNotBlank(dto.getKeyword())) {
			sql.append(" AND name LIKE '%"+dto.getKeyword()+"%'");
			sql.append(" OR code LIKE '%"+dto.getKeyword()+"%'");
			sql.append(" OR price LIKE '%"+dto.getKeyword()+"%'");
			sqlCount.append(" AND name LIKE '%"+dto.getKeyword()+"%'");
			sqlCount.append(" OR code LIKE '%"+dto.getKeyword()+"%'");
			sqlCount.append(" OR price LIKE '%"+dto.getKeyword()+"%'");
		}		
		
		
		
		Query query = em.createNativeQuery(sql.toString(),ProductEntity.class);
		Query queryCount = em.createNativeQuery(sqlCount.toString());
		
		int startPosition = pageIndex* pageSize;
		query.setFirstResult(startPosition);
		query.setMaxResults(dto.getPageSize());
		
		List<ProductEntity> productEntities = query.getResultList();
		BigInteger count =   (BigInteger) queryCount.getSingleResult();
		long total = count.longValue();
		Pageable pageable = new PageRequest(pageIndex,pageSize);
		Page<ProductEntity> page3 = new PageImpl<ProductEntity>(productEntities,pageable,total);
		return page3;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEntity> findByDateMin() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT * FROM product where DAYOFMONTH(now())-dayofmonth(createddate)<7 ");
		Query query = em.createNativeQuery(sql.toString(),ProductEntity.class);
		List<ProductEntity> productEntities = query.getResultList();		
		return productEntities;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDto> getProductAsCategory(ProductDto productDto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT  *FROM product INNER JOIN product_category ON product.id = product_category.product_id");
		sql.append(" INNER JOIN categorys ON categorys.id = product_category.category_id WHERE 1 = 1 ");
		List<String> listCategoryName = new ArrayList<String>();
		
		if (productDto.getCategoryDtos() != null) {
			int categoryIndex =0;
			
			for (CategoryDto categoryDto : productDto.getCategoryDtos()) {
				listCategoryName.add(categoryDto.getName());
			}
			
			for (String categoryEntity : listCategoryName) {
				categoryIndex+=1;
				sql.append("AND categorys.name = :category"+categoryIndex);
			}
		}
		Query query = em.createNativeQuery(sql.toString(),ProductEntity.class);
		if (productDto.getCategoryDtos() != null) {
			int index=0;
			for(String categoryEntityName : listCategoryName) {
				index+=1;
				query.setParameter("category"+index,categoryEntityName);
			}
		}
		List<ProductDto> listProductDtos = query.getResultList(); 
		
		return listProductDtos;
		
	}

}
