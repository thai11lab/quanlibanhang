package webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webbanhang.entity.OrderEntity;
import webbanhang.repository.custom.OrderRepositoryCustom;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long>,OrderRepositoryCustom{

}
