package webbanhang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webbanhang.entity.ProductEntity;
import webbanhang.repository.custom.ProductRepositoryCustom;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>,ProductRepositoryCustom{
	
	
	
}
