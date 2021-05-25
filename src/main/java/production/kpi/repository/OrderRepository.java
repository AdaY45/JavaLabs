package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.order.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findOrdersByStatusStartsWith(String filterText);

    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.client LEFT JOIN FETCH o.plane LEFT JOIN FETCH o.type")
    List<Order> findAll();
}
