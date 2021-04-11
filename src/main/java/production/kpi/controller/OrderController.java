package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import production.kpi.pojo.order.Order;
import production.kpi.service.OrderService;

import java.util.List;


public class OrderController {
    @Autowired
    private OrderService orderService;

    Order findOrderById( Integer id) {
        return orderService.getOrderById(id);
    }


    List<Order> findAll() {
        return orderService.getAllOrders();
    }
}
