package production.pojo.plane;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import production.pojo.order.Order;
import production.pojo.people.Client;
import production.pojo.people.Worker;
import java.util.List;

@Data
@Component
@AllArgsConstructor
public class Navy {
    private int id;
    private String model;
    private String manufacturer;
    private String status;
    private String cost;
    private int speed;
    private List<PlanePart> parts;
    private List<Order> orders;
    private List<Client> client;
    private List<Worker> worker;
}
