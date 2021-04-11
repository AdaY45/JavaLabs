package production.kpi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.kpi.pojo.order.Order;
import production.kpi.pojo.people.Client;
import production.kpi.repository.OrderRepository;
import production.kpi.service.ClientService;
import production.kpi.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientService clientService;

    @Override
    public List<Order> getOrdersOfClient(Integer id) {
        Client client = clientService.getClientById(id);
        return client.getOrders();
    }

    @Override
    public Order changeOrderStatus(Integer id, Order.OrderStatus status) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        order.setStatus(status);
        return order;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public boolean deleteOrder(Integer id) {
        orderRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
