package production.repository;

import org.apache.commons.lang3.NotImplementedException;
import production.pojo.order.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();

    Order findById(Integer id);

    Order update(Order order);

    Order save(Order order);

    boolean delete(Integer id);
}
