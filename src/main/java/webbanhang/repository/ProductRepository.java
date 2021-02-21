package webbanhang.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webbanhang.dto.ProductDto;
import webbanhang.entity.ProductEntity;
import webbanhang.repository.custom.ProductRepositoryCustom;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>,ProductRepositoryCustom{

	

	
	
	
	
}
