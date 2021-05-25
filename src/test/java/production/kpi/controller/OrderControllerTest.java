package production.kpi.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import production.kpi.KpiApplication;
import production.kpi.pojo.order.Order;
import production.kpi.pojo.people.Client;
import production.kpi.pojo.plane.Navy;
import production.kpi.pojo.plane.TypeOfWork;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KpiApplication.class)
public class OrderControllerTest {
    @Autowired
    private OrderController orderController;
    @Autowired
    private NavyController navyController;
    @Autowired
    private ClientController clientController;
    private List<Order> orders;
    private Integer orderId;

    @Before
    public void setUp() {
        orders = orderController.findAll();
    }

    @Test
    public void findAll() {
        Client client = new Client(1, "Zarichniy", "Oleg", "dfgdfg@gmail.com", "fdgdgfgd");
        Client client2 = new Client(2, "Bogdanets", "Olexandr", "bogolex@gmail.com", "bog12345");
        Navy plane = new Navy(1, "F/A-18E/F Super Hornet", "In service", "US$66.0 million", 1915D);
        Navy plane2 = new Navy(2, "E-2 Hawkeye", "In service", "US$176 million", 650D);
        Navy plane3 = new Navy(3, "P-8 Poseidon", "In service", "US$256.5 million", 907D);
        Navy plane4 = new Navy(4, "EA-18G Growler", "In service", "US$68.2 million", 1900D);
        Navy plane5 = new Navy(5, "E-6 Mercury", "In service", "US$141.7 million", 980D);
        Navy plane6 = new Navy(6, "P-8 Poseidon", "In service", "US$256.5 million", 907D);
        Navy plane7 = new Navy(7, "F/A-18E/F Super Hornet", "In service", "US$66.0 million", 1915D);
        Navy plane8 = new Navy(8, "E-2 Hawkeye", "In service", "US$176 million", 650D);
        Navy plane9 = new Navy(9, "E-6 Mercury", "In service", "US$141.7 million", 980D);
        Navy plane10 = new Navy(10, "EP-3", "Active", "US$36 million", 700D);
        TypeOfWork type = new TypeOfWork(TypeOfWork.Type.REPARATION);
        TypeOfWork type1 = new TypeOfWork(TypeOfWork.Type.CONSTRUCTION);
        List<Navy> planes = List.of(plane, plane2, plane3, plane4, plane5, plane6, plane7, plane8, plane9, plane10);
        List<Order> expected = new ArrayList<>();
        Order order1 = new Order(client, planes, type, 1, Order.OrderStatus.PENDING);
        Order order2 = new Order(client2, planes, type1, 2, Order.OrderStatus.CONFIRMED);
        order1.setId(1);
        order2.setId(2);
        expected.add(order1);
        expected.add(order2);
        List<Order> orders = orderController.findAll();
        Assertions.assertEquals(expected, orders);
    }

    @Test
    public void save() {
        Client client = new Client();
        Navy navy = new Navy();
        TypeOfWork type = new TypeOfWork(TypeOfWork.Type.REPARATION);
        Order test = new Order(client, List.of(navy), type, 1, Order.OrderStatus.PENDING);
        clientController.save(client);
        navyController.save(navy);
        Order actual1 = orderController.save(test);
        List<Order> actual = orderController.findAll();
        orderId = actual.get(actual.size() - 1).getId();
        orders.get(orders.size() - 1).setId(orderId);
        test.setId(orderId);
        assertEquals(test, actual1);
    }

    @After
    public void tearDown() {
        if (orderId != null) {
            orderController.deleteById(orderId);
        }
    }
}
