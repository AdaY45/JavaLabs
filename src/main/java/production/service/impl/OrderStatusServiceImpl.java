package production.service.impl;

import org.springframework.stereotype.Service;
import production.pojo.order.OrderStatus;
import production.service.OrderStatusService;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    @Override
    public OrderStatus save(OrderStatus orderStatus) {
        return null;
    }

    @Override
    public OrderStatus findByTitle(String title) {
        return null;
    }
}
