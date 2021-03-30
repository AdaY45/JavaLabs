package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import production.pojo.order.OrderStatus;
import production.repository.OrderStatusRepository;

@Repository
public class OrderStatusRepositoryImpl implements OrderStatusRepository {
    @Override
    public OrderStatus save(OrderStatus orderStatus) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public OrderStatus findByTitle(String title) {
        throw new NotImplementedException("TODO");
    }
}
