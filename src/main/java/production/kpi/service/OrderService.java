package production.kpi.service;

import production.kpi.pojo.order.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersOfClient(Integer id);

    Order changeOrderStatus(Integer id, Order.OrderStatus status);

    Order saveOrder(Order order);

    Order getOrderById(Integer id);

    boolean deleteOrder(Integer id);

    List<Order> getAllOrders();
}
