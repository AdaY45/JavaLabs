package production.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import production.pojo.order.Order;
import production.service.OrderService;
import java.util.List;

@RestController("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/id")
    Order findOrderById(@RequestParam(name = "id") Integer id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    List<Order> findAll() {
        return orderService.getAllOrders();
    }
}
