package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import production.kpi.pojo.order.Order;
import production.kpi.service.OrderService;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    public Order findOrderById( Integer id) {
        return orderService.getOrderById(id);
    }

    public List<Order> findAll() {
        return orderService.getAllOrders();
    }

    /*public List<Order> getOrdersOfClient(Integer id) {
        return orderService.getOrdersOfClient(id);
    }*/

    public Order changeOrderStatus(Integer id, Order.OrderStatus status) {
        return orderService.changeOrderStatus(id,status);
    }

    public Order save(Order order) {
        return orderService.saveOrder(order);
    }

    public boolean deleteById(Integer id) {
        return orderService.deleteOrder(id);
    }

    public List<Order> findOrderByStatus(String filterText) {
        return orderService.findOrderByStatus(filterText);
    }
}
