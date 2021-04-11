package production.kpi.pojo.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import production.kpi.pojo.people.Client;
import production.kpi.pojo.plane.Navy;
import production.kpi.pojo.plane.TypeOfWork;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@Component
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id")
    private Navy plane;

    @ManyToOne(fetch = FetchType.LAZY)
    private TypeOfWork type;

    private Integer amount;
    private OrderStatus status;

    public enum OrderStatus {
        PENDING("Pending"), CONFIRMED("Confirmed"), SHIPPED("Shipped"),
        DELIVERED("Delivered"), CANCELLED("Cancelled");

        private final String title;

        OrderStatus(String title) {
            this.title = title;
        }
    }
}
