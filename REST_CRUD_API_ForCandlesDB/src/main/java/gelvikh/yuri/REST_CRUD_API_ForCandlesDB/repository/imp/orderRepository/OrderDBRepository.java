package gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.imp.orderRepository;

import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.model.orders.Order;
import gelvikh.yuri.REST_CRUD_API_ForCandlesDB.repository.AbstractDBRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDBRepository extends JpaRepository<Order, Long>, AbstractDBRepository<Order> {
    @Override
    default Optional<Order> findByName(String name) {
        return this.findByUsername(name);
    }
    Optional<Order> findByUsername(String username) ;
}
