package production.kpi.pojo.plane;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import production.kpi.pojo.order.Order;
import production.kpi.pojo.people.Client;
import production.kpi.pojo.people.Worker;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "planes")
@Data
@NoArgsConstructor
public class Navy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String manufacturer;
    private String status;
    private String cost;
    private int speed;

    @OneToMany
    private List<PlanePart> parts;
    @OneToMany
    private List<Order> orders;
    @OneToMany
    private List<Client> client;
    @OneToMany
    private List<Worker> workers;

    public Navy(String model, String manufacturer, String status, String cost, int speed) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.status = status;
        this.cost = cost;
        this.speed = speed;
    }
}
