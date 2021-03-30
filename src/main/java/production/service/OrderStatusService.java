package production.service;

import production.pojo.order.OrderStatus;

public interface OrderStatusService {
    OrderStatus save (OrderStatus orderStatus);

    OrderStatus findByTitle(String title);
}
