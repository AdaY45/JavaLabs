package production.pojo.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import production.pojo.order.Order;
import java.util.LinkedList;
import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private final List<Order> orders = new LinkedList<>();
}
