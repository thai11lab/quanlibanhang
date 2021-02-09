package webbanhang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import webbanhang.entity.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
	
	@Query("SELECT entity.id FROM ProductCategory entity WHERE productEntity.id = ?1")
	List<Long> getCategoryFromProductId(Long productId);
	
}
