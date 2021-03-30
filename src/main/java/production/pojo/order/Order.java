package production.pojo.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import production.pojo.people.Client;
import production.pojo.plane.Navy;
import production.pojo.plane.TypeOfWork;

@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class Order {
    private Integer id;
    private Client client;
    private Navy plane;
    private TypeOfWork type;
    private Integer amount;
    private OrderStatus status;
}
