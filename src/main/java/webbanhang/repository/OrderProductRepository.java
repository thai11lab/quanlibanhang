package webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webbanhang.entity.OrderProductEntity;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity,Long>{

}
