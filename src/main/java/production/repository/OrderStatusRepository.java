package production.repository;

import production.pojo.order.OrderStatus;

public interface OrderStatusRepository {
    OrderStatus save (OrderStatus orderStatus);

    OrderStatus findByTitle(String title);
}
