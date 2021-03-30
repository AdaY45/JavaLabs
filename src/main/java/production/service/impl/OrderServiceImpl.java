package production.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.pojo.order.Order;
import production.pojo.order.OrderStatus;
import production.pojo.people.Client;
import production.repository.ClientRepository;
import production.repository.OrderRepository;
import production.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Order> getOrdersOfClient(Integer id) {
        Client client = clientRepository.findClientById(id);
        return client.getOrders();
    }

    @Override
    public Order changeOrderStatus(Integer id, OrderStatus status) {
        Order order = orderRepository.findById(id);
        order.setStatus(status);
        return order;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public boolean deleteOrder(Integer id) {
        return orderRepository.delete(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
