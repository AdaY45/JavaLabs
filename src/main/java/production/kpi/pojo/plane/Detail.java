package production.kpi.pojo.plane;

import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "details")
@Data
@NoArgsConstructor
@SpringComponent
@EqualsAndHashCode
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private Double weight;
    private String model;

    public Detail (String description, Double weight, String model) {
        this.description = description;
        this.weight = weight;
        this.model = model;
    }
}
