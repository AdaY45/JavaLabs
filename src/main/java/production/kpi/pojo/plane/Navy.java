package production.kpi.pojo.plane;

import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "planes")
@Data
@NoArgsConstructor
@SpringComponent
public class Navy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String model;
    private String status;
    private String cost;
    private Double speed;

    public Navy(String model, String status, String cost, Double speed) {
        this.model = model;
        this.status = status;
        this.cost = cost;
        this.speed = speed;
    }

    public Navy(int id, String model, String status, String cost, Double speed) {
        this.id = id;
        this.model = model;
        this.status = status;
        this.cost = cost;
        this.speed = speed;
    }

    /*public Navy(String model, String status, String cost, int speed, List<Worker> workers) {
        this.model = model;
        this.status = status;
        this.cost = cost;
        this.speed = speed;
        this.workers = workers;
    }*/
}
