package production.kpi.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import production.kpi.pojo.order.Order;
import production.kpi.repository.OrderRepository;
import production.kpi.service.impl.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderServiceImpl orderService;
    private Order order;
    private List<Order> orders;

    @Before
    public void setUp() throws Exception {
        order = new Order();
        orders = new ArrayList<>();
        orders.add(order);
    }

    @Test
    public void changeOrderStatus() {
        when(orderRepository.findById(1)).thenReturn(Optional.ofNullable(order));
        order.setStatus(Order.OrderStatus.PENDING);
        Order newOrder = new Order();
        newOrder.setStatus(Order.OrderStatus.SHIPPED);
        Assert.assertEquals(newOrder, orderService.changeOrderStatus(1, Order.OrderStatus.SHIPPED));
        verify(orderRepository).findById(1);
    }

    @Test
    public void saveOrder() {
        when(orderRepository.save(order)).thenReturn(order);
        assertEquals(order, orderService.saveOrder(order));
        verify(orderRepository).save(order);
    }

    @Test
    public void getOrderById() {
        when(orderRepository.findById(1)).thenReturn(Optional.ofNullable(order));
        assertEquals(order, orderService.getOrderById(1));
        verify(orderRepository).findById(1);
    }

    @Test
    public void getAllOrders() {
        when(orderRepository.findAll()).thenReturn(orders);
        assertEquals(orders, orderService.getAllOrders());
        verify(orderRepository).findAll();
    }
}