package production.service;

import production.pojo.order.Order;
import production.pojo.order.OrderStatus;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersOfClient(Integer id);

    Order changeOrderStatus(Integer id, OrderStatus status);

    Order saveOrder(Order order);

    Order getOrderById(Integer id);

    boolean deleteOrder(Integer id);

    List<Order> getAllOrders();
}
