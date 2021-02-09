package webbanhang.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;

import webbanhang.dto.searchDto.searchDto;
import webbanhang.entity.ProductEntity;
import webbanhang.repository.custom.ProductRepositoryCustom;

public class ProductRepositoryImpl implements ProductRepositoryCustom{
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public Page<ProductEntity> findBySearch(searchDto dto) {
		StringBuilder sql = new StringBuilder("SELECT ");
		return null;
	}

}
