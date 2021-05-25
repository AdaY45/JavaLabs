package production.kpi.pojo.order;

import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import production.kpi.pojo.people.Client;
import production.kpi.pojo.plane.Navy;
import production.kpi.pojo.plane.TypeOfWork;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Component
@NoArgsConstructor
@SpringComponent
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id")
    private List<Navy> plane;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private TypeOfWork type;

    private Integer amount;
    private OrderStatus status;

    public Order(Client client, List<Navy> plane, TypeOfWork type, Integer amount, OrderStatus orderStatus) {
        this.client = client;
        this.plane = plane;
        this.type = type;
        this.amount = amount;
        this.status = orderStatus;
    }

    public Order(Integer amount, OrderStatus status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public enum OrderStatus {
        PENDING("Pending"), CONFIRMED("Confirmed"), SHIPPED("Shipped"),
        DELIVERED("Delivered"), CANCELLED("Cancelled");

        private final String title;

        OrderStatus(String title) {
            this.title = title;
        }
    }
}
