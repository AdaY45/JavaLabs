package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import production.pojo.order.Order;
import production.repository.OrderRepository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    public List<Order> findAll() {
        throw new NotImplementedException("TODO");
    }

    public Order findById(Integer id) {
        throw new NotImplementedException("TODO");
    }

    public Order update(Order order) {
        throw new NotImplementedException("TODO");
    }

    public Order save(Order order) {
        throw new NotImplementedException("TODO");
    }

    public boolean delete(Integer id) {
        throw new NotImplementedException("TODO");
    }
}
