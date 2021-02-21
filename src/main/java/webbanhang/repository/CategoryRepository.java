package webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webbanhang.entity.CategoryEntity;
import webbanhang.repository.custom.CategoryRepositoryCustom;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>,CategoryRepositoryCustom{

}
